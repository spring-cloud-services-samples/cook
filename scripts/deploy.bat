@echo off
if "%1"=="" (
  echo Please provide the path to the application archive.
) else (
  cf create-service p-config-server standard config-server
  echo Please visit Apps Manager and enter a repository URI for the new "config-server" service. Then press any key to continue...
  pause > nul
  cf push -p %1
)
