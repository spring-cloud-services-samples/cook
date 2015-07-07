if [ "$1" == "" ]
then
  echo "Please provide the path to the application archive."
  exit 1
fi
cf create-service p-config-server standard config-server
read -p "Please visit Apps Manager and enter a repository URI for the new \"config-server\" service. Then press any key to continue..." -n1 -s
echo
cf push -p "$@"
