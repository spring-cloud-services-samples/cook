@echo off
if "%1"=="" (
  echo Please provide the path to the application archive.
) else (
  echo Creating Config Server...
  cf create-service p-config-server standard cook-config-server > nul
  :check
    cf service cook-config-server | find "succeeded" > nul
    if errorlevel 1 goto :check
    echo Config Server created. Pushing application.
    cf push -p %1
)
