#!/bin/bash

mvn clean package -DskipTests

if [[ "${RUN_TESTS,,}" != 'false' ]]; then
	mvn test -P run-integration-tests
fi

docker build \
	-t lion78at/calculator \
	--no-cache \
	.

echo "dckr_pat_l_gkfMe8gjOgcWxl9H6J_TKLoI8" | docker login \
	-u lion78at \
	--password-stdin

docker push \
	lion78at/calculator

kubectl config \
	use-context kubernetes-admin@kubernetes

kubectl apply \
	-f calculator-ci.yaml

mvn clean