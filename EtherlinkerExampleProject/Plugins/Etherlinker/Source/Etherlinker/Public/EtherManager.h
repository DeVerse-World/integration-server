#pragma once

#include "CoreMinimal.h"
#include "GameFramework/Actor.h"
#include "Misc/Paths.h"
#include "Kismet/GameplayStatics.h"
#include "Components/ActorComponent.h"
#include "Runtime/Online/HTTP/Public/Http.h"
#include "JsonGlobals.h"
#include "Policies/JsonPrintPolicy.h"
#include "Policies/PrettyJsonPrintPolicy.h"
#include "Policies/CondensedJsonPrintPolicy.h"
#include "Serialization/JsonTypes.h"
#include "Dom/JsonValue.h"
#include "Dom/JsonObject.h"
#include "Serialization/JsonReader.h"
#include "Serialization/JsonWriter.h"
#include "Serialization/JsonSerializer.h"
#include "Serialization/JsonSerializerMacros.h"
#include "JsonObjectConverter.h"
#include "EtherlinkerTypes.h"
#include "EtherlinkerSettings.h"
#include "EtherManager.generated.h"

class UEtherlinkerSettings;

UCLASS(BlueprintType, Blueprintable, ClassGroup = (Custom), meta = (BlueprintSpawnableComponent))
class ETHERLINKER_API UEtherManager : public UActorComponent
{
	GENERATED_BODY()

public:
	// Sets default values for this component's properties
	UEtherManager();

	/**
	 * Wallet data
	 */
	UPROPERTY(SaveGame)
	FWalletData walletData;

	/**
	 * Event dispatcher - OnResponseReceived
	 */
	UPROPERTY(BlueprintAssignable)
	FResponseReceivedDelegate OnResponseReceivedEvent;

	/**
	 * Event dispatcher - OnBatchResponseReceived
	 */
	UPROPERTY(BlueprintAssignable)
	FBatchResponseReceivedDelegate OnBatchResponseReceivedEvent;

	/**
	 * Get wallet balance
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void GetWalletBalance(FEtherlinkerRequestData etherlinkerRequestData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerGetWalletBalance(FEtherlinkerRequestData etherlinkerRequestData);

	void ServerGetWalletBalance_Implementation(FEtherlinkerRequestData etherlinkerRequestData);

	bool ServerGetWalletBalance_Validate(FEtherlinkerRequestData etherlinkerRequestData);

	/**
	 * Transfer ether
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void TransferEther(FEtherlinkerRequestData etherlinkerRequestData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerTransferEther(FEtherlinkerRequestData etherlinkerRequestData);

	void ServerTransferEther_Implementation(FEtherlinkerRequestData etherlinkerRequestData);

	bool ServerTransferEther_Validate(FEtherlinkerRequestData etherlinkerRequestData);


	/**
	 * Execute custom contract method
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void ExecContractMethod(FEtherlinkerRequestData etherlinkerRequestData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerExecContractMethod(FEtherlinkerRequestData etherlinkerRequestData);

	void ServerExecContractMethod_Implementation(FEtherlinkerRequestData etherlinkerRequestData);

	bool ServerExecContractMethod_Validate(FEtherlinkerRequestData etherlinkerRequestData);

	/**
	 * Deploy custom contract, which definition is already generated by Web3j
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void DeployContract(FEtherlinkerRequestData etherlinkerRequestData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerDeployContract(FEtherlinkerRequestData etherlinkerRequestData);

	void ServerDeployContract_Implementation(FEtherlinkerRequestData etherlinkerRequestData);

	bool ServerDeployContract_Validate(FEtherlinkerRequestData etherlinkerRequestData);

	/**
	 * Create new wallet with BIP39 mnemonic
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void CreateWallet(FEtherlinkerRequestData etherlinkerRequestData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerCreateWallet(FEtherlinkerRequestData etherlinkerRequestData);

	void ServerCreateWallet_Implementation(FEtherlinkerRequestData etherlinkerRequestData);

	bool ServerCreateWallet_Validate(FEtherlinkerRequestData etherlinkerRequestData);

	/**
	 * Set wallet data to use it in other methods later
	 *
	 * @param newWalletData parameter with wallet data to enhance requests with it
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void SetWalletData(FWalletData newWalletData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerSetWalletData(FWalletData newWalletData);

	void ServerSetWalletData_Implementation(FWalletData newWalletData);

	bool ServerSetWalletData_Validate(FWalletData newWalletData);

	/**
	 * Process batch request and send it to the Integration Server
	 *
	 * @param etherlinkerBatchRequestData batch request data to send to the Integration Server
	 */
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	void ProcessBatchRequest(FEtherlinkerBatchRequestData etherlinkerBatchRequestData);

	UFUNCTION(Reliable, Server, WithValidation)
	void ServerProcessBatchRequest(FEtherlinkerBatchRequestData etherlinkerBatchRequestData);

	void ServerProcessBatchRequest_Implementation(FEtherlinkerBatchRequestData etherlinkerBatchRequestData);

	bool ServerProcessBatchRequest_Validate(FEtherlinkerBatchRequestData etherlinkerBatchRequestData);
	
private:

	/**
	 * Make a JSON request over HTTP
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	 * @param URL MVC controller method address on integration server 
	 * @return true if request successfully sent
	 */
	bool MakeRequest(FEtherlinkerRequestData EtherlinkerRequestData, const FString& URL);

	/**
	 * Make a JSON batch request over HTTP
	 *
	 * @param etherlinkerBatchRequestData batch request data to send to the Integration Server
	 * @param URL MVC controller method address on integration server
	 * @return true if request successfully sent
	 */
	bool MakeBatchRequest(FEtherlinkerBatchRequestData EtherlinkerBatchRequestData, const FString& URL);

	/**
	 * Receive response for JSON request
	 *
	 * @param Request request data, which was sent to the integration server
	 * @param Response response from the integration server
	 * @param bWasSuccessful true if response successfully processed on the integration server
	 */
	void OnResponseReceived(FHttpRequestPtr Request, FHttpResponsePtr Response, bool bWasSuccessful);

	/**
	 * Receive batch response for JSON request
	 *
	 * @param Request request data, which was sent to the integration server
	 * @param Response response from the integration server
	 * @param bWasSuccessful true if response successfully processed on the integration server
	 */
	void OnBatchResponseReceived(FHttpRequestPtr Request, FHttpResponsePtr Response, bool bWasSuccessful);

	/**
	 * Add wallet data to the selected request structure
	 *
	 * @param etherlinkerRequestData request data to send to the Integration Server
	*/
	UFUNCTION(BlueprintCallable, Category = "EtherManager")
	FEtherlinkerRequestData AddWalletDataToRequest(FEtherlinkerRequestData etherlinkerRequestData) const;

};