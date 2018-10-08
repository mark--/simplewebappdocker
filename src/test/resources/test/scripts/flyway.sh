#!/bin/bash
echo "***** Starting Flyway"
echo "* Waiting 5 seconds for database"

sleep 5

cd /tmp/flyway
./flyway -url=jdbc:postgresql://database:5432/postgres -user=postgres -password=reverse migrate

