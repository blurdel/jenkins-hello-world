#!/bin/bash

PROP_FILE=build.properties

if [[ ! -e "${PROP_FILE}" ]]; then
    echo "Error: ${PROP_FILE} not found, exiting ..."
    exit
fi

source "${PROP_FILE}"

docker run -d --rm \
    --name "${APP_NAME}" -p 8080:8080 "${REGISTRY}"/"${APP_NAME}":"${APP_VERSION}"
