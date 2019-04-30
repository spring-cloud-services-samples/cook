if (!$args) {
  Write-Output "Please provide the path to the application archive."
  exit 1
}

$cfmOutput=(cf m) | Out-String

if ($cfmOutput -like "*p.config-server*") {
  $serviceName = "p.config-server"
} elseif ($cfmOutput -like "*p-config-server*") {
  $serviceName = "p-config-server"
} else {
  Write-Output "Can't find SCS Config Server in marketplace. Have you installed the SCS Tile?"
  exit 1
}

$configJson = "`"{\`"git\`":{\`"uri\`":\`"https://github.com/spring-cloud-services-samples/cook-config\`",\`"label\`":\`"master\`"}}`""
cf create-service $serviceName standard cook-config-server -c $configJson

do {
  $createStatus=(cf service cook-config-server) | Out-String -stream | Select-String -Pattern "Status" -CaseSensitive -SimpleMatch
  Write-Progress -Activity "Creating Config Server..." -Status $createStatus
}
until($createStatus -like "*succeeded*")

Write-Output "Config Server created. Pushing application."
cf push -p $args[0]
Write-Output "Done!"
