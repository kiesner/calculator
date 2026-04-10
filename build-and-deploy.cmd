@echo off

call mvn clean package -DskipTests

if /i not "%RUN_TESTS%" == "false" (
	call mvn test -P run-integration-tests
)

docker build ^
	-t lion78at/calculator ^
	--no-cache ^
	.

docker login ^
	-u lion78at

docker push ^
	lion78at/calculator

kubectl config ^
	use-context kubernetes-admin@kubernetes

kubectl apply ^
	-f calculator-ci.yaml

call mvn clean