cd /d %1
call mvnw org.web3j:web3j-maven-plugin:4.0.3:generate-sources
IF %ERRORLEVEL% NEQ 0 (
  pause
  EXIT /B 1
)