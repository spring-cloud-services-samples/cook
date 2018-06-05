#!/usr/bin/env bash
if [ "$1" == "" ]
then
  echo "Please provide the path to the application archive."
  exit 1
fi
echo -n "Creating Config Server..."
{
  cf create-service -c '{ "git": { "uri": "https://github.com/spring-cloud-services-samples/cook-config", "label": "master"  } }' p-config-server standard cook-config-server
} &> /dev/null
until [ `cf service cook-config-server | grep -c "succeeded"` -eq 1  ]
do
  echo -n "."
done
echo
echo "Config Server created. Pushing application."
cf push -p "$@"
echo "Done!"
