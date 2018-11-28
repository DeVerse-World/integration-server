#include "EtherlinkerSettings.h"

UEtherlinkerSettings::UEtherlinkerSettings(const FObjectInitializer& ObjectInitializer)
	: Super(ObjectInitializer),
	ContractsToCompileDirectory(""),
	IntegrationServerSourceDirectory(""),
	IntegrationServerURL("https://localhost:8451"),
	IntegrationServerParameters("-Xms128m -Xmx512m"),
	IsLocalIntegrationServer(true),
	RunIntegrationServerSilently(false),
	CompileContractsScript("compileContracts.bat"),
	CompileIntegrationServerScript("compileIntegrationServer.bat"),
	DefaultWalletPath(""),
	//MavenDirectory(""),
	InfuraURL("")/*,
	StartServerScriptPath(""),
	StopServerScriptPath(""),
	RestartServerScriptPath(""),
	CheckServerScriptPath("")*/
{
}
