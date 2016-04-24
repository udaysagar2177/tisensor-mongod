#!/bin/bash
set -xe

function stop_and_remove_container(){
        # Stop and remove container
        if [[ $(docker ps -a | grep "$1") ]]; then
            docker rm -f $1
        else
            echo "container not found for $1"
        fi
}

stop_and_remove_container "rest_api"

docker run \
-it \
--name "rest_api" \
--link mongodb:mongodb \
-e environment='production' \
-e DATABASE_NAME='adenosine' \
-e DATABASE_USERNAME='' \
-e DATABASE_PASSWORD='' \
-e DATABASE_HOSTNAME='mongodb' \
-e DATABASE_PORT='27017' \
-e DATAPOINT_REST_URL='http://localhost:8080/tisensor' \
-e NUMBER_OF_TISENSOR_SIMULATIONS='3' \
-p 8081:8080 \
-v $(pwd)/rest-api:/rest-api \
maven \
bash -c "cd /rest-api && mvn tomcat7:run"