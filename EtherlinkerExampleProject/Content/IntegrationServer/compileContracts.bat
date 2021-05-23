cd /d %1
call mvnw io.github.zebraofjustice:web3j-maven-plugin:4.8.1.zebraofjustice:generate-sources
IF %ERRORLEVEL% NEQ 0 (
  pause
  EXIT /B 1
)