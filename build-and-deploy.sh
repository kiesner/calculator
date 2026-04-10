#!/bin/bash

mvn clean package -DskipTests

if [[ "${RUN_TESTS,,}" != 'false' ]]; then
	mvn test -P run-integration-tests
fi

docker build \
	-t lion78at/calculator \
	--no-cache \
	.

docker login \
	-u lion78at

docker push \
	lion78at/calculator

kubectl config \
	use-context kubernetes-admin@kubernetes

kubectl apply \
	-f calculator-ci.yaml

mvn clean