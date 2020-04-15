#!/bin/bash

export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
export VAULT_ADDR="http://127.0.0.1:8200"


export DB_PWD=$(vault kv get -field=password secret/twelve-factor)
export DB_UNAME=$(vault kv get -field=username secret/twelve-factor)

export DB_URL=jdbc:postgresql://localhost:5432/twelve_factor1
export SERVER_PORT=8888

./gradlew bootRun