package com.academy.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class PremiumSubscriptionToken extends Contract {
    private static final String BINARY = "608060405260038054600160a060020a03191633179055611a74806100256000396000f3006080604052600436106101535763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663095ea7b381146101585780631420ee221461018e57806318160ddd146101b05780631c1c641d146101d257806323b872dd146101f257806327de2f8d1461021257806331ecad6614610232578063395093511461025257806342966c681461027257806366951e391461029257806370a08231146102b2578063715018a6146102d257806379cc6790146102e75780638da5cb5b146103075780639201de551461032957806394e8767d14610356578063a457c2d714610376578063a4faf09f14610396578063a9059cbb146103b6578063acabdf75146103d6578063cd055531146103f6578063dd62ed3e14610416578063e2cee85e14610436578063e939567914610456578063f2a90b4b14610476578063f2fde38b14610496575b600080fd5b34801561016457600080fd5b50610178610173366004611760565b6104b6565b604051610185919061199b565b60405180910390f35b34801561019a57600080fd5b506101ae6101a93660046117c2565b610539565b005b3480156101bc57600080fd5b506101c56105e7565b60405161018591906119a9565b3480156101de57600080fd5b506101c56101ed366004611874565b6105ed565b3480156101fe57600080fd5b5061017861020d366004611713565b610602565b34801561021e57600080fd5b5061017861022d366004611760565b61069f565b34801561023e57600080fd5b506101ae61024d366004611874565b610818565b34801561025e57600080fd5b5061017861026d366004611760565b610881565b34801561027e57600080fd5b506101ae61028d366004611874565b610924565b34801561029e57600080fd5b506101ae6102ad366004611804565b610931565b3480156102be57600080fd5b506101c56102cd3660046116bb565b610a3e565b3480156102de57600080fd5b506101ae610a59565b3480156102f357600080fd5b506101ae610302366004611760565b610ac7565b34801561031357600080fd5b5061031c610ad5565b604051610185919061198d565b34801561033557600080fd5b50610349610344366004611874565b610ae4565b60405161018591906119b7565b34801561036257600080fd5b506101c5610371366004611874565b610c5a565b34801561038257600080fd5b50610178610391366004611760565b610cb8565b3480156103a257600080fd5b506101ae6103b1366004611892565b610d03565b3480156103c257600080fd5b506101786103d1366004611760565b610d8d565b3480156103e257600080fd5b506101ae6103f1366004611804565b610da3565b34801561040257600080fd5b506101ae610411366004611790565b610ea8565b34801561042257600080fd5b506101c56104313660046116d9565b61105e565b34801561044257600080fd5b506101ae610451366004611892565b611089565b34801561046257600080fd5b50610349610471366004611874565b611290565b34801561048257600080fd5b506101ae610491366004611892565b61129e565b3480156104a257600080fd5b506101ae6104b13660046116bb565b61131b565b6000600160a060020a03831615156104cd57600080fd5b336000818152600160209081526040808320600160a060020a03881680855292529182902085905590519091907f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925906105279086906119a9565b60405180910390a35060015b92915050565b600354600090600160a060020a0316331461055357600080fd5b5060005b818110156105e2576005600084848481811061056f57fe5b602090810292909201358352508101919091526040016000908120818155600101557fa51c5188e1948c771c5869a9d2c919518028dc8e3c947dd22fd3ae13aeda4c4a8383838181106105be57fe5b905060200201356040516105d291906119a9565b60405180910390a1600101610557565b505050565b60025490565b60009081526005602052604090206001015490565b600160a060020a038316600090815260016020908152604080832033845290915281205482111561063257600080fd5b600160a060020a0384166000908152600160209081526040808320338452909152902054610666908363ffffffff61133b16565b600160a060020a0385166000908152600160209081526040808320338452909152902055610695848484611352565b5060019392505050565b60006060836106ad84611290565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b602083106107065780518252601f1990920191602091820191016106e7565b6001836020036101000a0380198251168184511680821785525050505050509050019250505060405160208183030381529060405290506004816040518082805190602001908083835b6020831061076f5780518252601f199092019160209182019101610750565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922054421080159250905061081057506004816040518082805190602001908083835b602083106107da5780518252601f1990920191602091820191016107bb565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220600101544211159150505b949350505050565b600354600160a060020a0316331461082f57600080fd5b60008181526005602052604080822082815560010191909155517fa51c5188e1948c771c5869a9d2c919518028dc8e3c947dd22fd3ae13aeda4c4a906108769083906119a9565b60405180910390a150565b6000600160a060020a038316151561089857600080fd5b336000908152600160209081526040808320600160a060020a03871684529091529020546108cc908363ffffffff61144916565b336000818152600160209081526040808320600160a060020a038916808552925291829020849055905190927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259161052791906119a9565b61092e3382611462565b50565b600061093b611643565b600354600160a060020a0316331461095257600080fd5b84831461095e57600080fd5b600091505b84821015610a3657604080518082019091528087878581811061098257fe5b905060200201358152602001858585818110151561099c57fe5b905060200201358152509050806005600088888681811015156109bb57fe5b6020908102929092013583525081810192909252604001600020825181559101516001909101557f2bf5da1e90f7b3234642edd1283811b71e4130202f7f9024b5b260ae536af5df868684818110610a0f57fe5b90506020020135604051610a2391906119a9565b60405180910390a1600190910190610963565b505050505050565b600160a060020a031660009081526020819052604090205490565b600354600160a060020a03163314610a7057600080fd5b600354604051600160a060020a03909116907ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482090600090a26003805473ffffffffffffffffffffffffffffffffffffffff19169055565b610ad18282611533565b5050565b600354600160a060020a031681565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b6020831015610ba8576008830260020a870291507fff00000000000000000000000000000000000000000000000000000000000000821615610b9d57818585815181101515610b6657fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001909301925b600190920191610b1b565b836040519080825280601f01601f191660200182016040528015610bd6578160200160208202803883390190505b509050600092505b83831015610c50578483815181101515610bf457fe5b90602001015160f860020a900460f860020a028184815181101515610c1557fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600190920191610bde565b9695505050505050565b6000811515610c8a57507f3000000000000000000000000000000000000000000000000000000000000000610cb3565b6000821115610cb35761010081049050600a820660300160f860020a0217600a82049150610c8a565b919050565b6000600160a060020a0383161515610ccf57600080fd5b336000908152600160209081526040808320600160a060020a03871684529091529020546108cc908363ffffffff61133b16565b610d0b611643565b600354600160a060020a03163314610d2257600080fd5b506040805180820182528381526020808201848152600086815260059092529083902082518155905160019091015590517f2bf5da1e90f7b3234642edd1283811b71e4130202f7f9024b5b260ae536af5df90610d809085906119a9565b60405180910390a1505050565b6000610d9a338484611352565b50600192915050565b6000610dad611643565b600354600160a060020a03163314610dc457600080fd5b848314610dd057600080fd5b600091505b84821015610a36576040805180820190915280878785818110610df457fe5b9050602002013581526020018585858181101515610e0e57fe5b90506020020135815250905080600560008888868181101515610e2d57fe5b6020908102929092013583525081810192909252604001600020825181559101516001909101557f99e5fc2422da5e949a914149894c1b8cb972a4edec220e66c58a5968a668dc0d868684818110610e8157fe5b90506020020135604051610e9591906119a9565b60405180910390a1600190910190610dd5565b610eb0611643565b600354606090600160a060020a03163314610eca57600080fd5b6000838152600560205260409020541515610ee457600080fd5b610eee858461069f565b15610f2e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610f25906119c8565b60405180910390fd5b6040805180820190915242808252620151808602016020820152915084610f5484611290565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b60208310610fad5780518252601f199092019160209182019101610f8e565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040529050816004826040518082805190602001908083835b602083106110175780518252601f199092019160209182019101610ff8565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084518155939092015160019093019290925550505050505050565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b611091611643565b60008281526005602052604090205460609015156110ae57600080fd5b60008381526005602052604090206001015484026110cb33610a3e565b1015611103576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610f25906119d8565b61110d338461069f565b15611144576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610f25906119c8565b600083815260056020526040902060010154611161908502610924565b604080518082019091524280825262015180860201602082015291503361118784611290565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b602083106111e05780518252601f1990920191602091820191016111c1565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040529050816004826040518082805190602001908083835b6020831061124a5780518252601f19909201916020918201910161122b565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845181559390920151600190930192909255505050505050565b606061053361034483610c5a565b6112a6611643565b600354600160a060020a031633146112bd57600080fd5b506040805180820182528381526020808201848152600086815260059092529083902082518155905160019091015590517f99e5fc2422da5e949a914149894c1b8cb972a4edec220e66c58a5968a668dc0d90610d809085906119a9565b600354600160a060020a0316331461133257600080fd5b61092e816115c5565b6000808383111561134b57600080fd5b5050900390565b600160a060020a03831660009081526020819052604090205481111561137757600080fd5b600160a060020a038216151561138c57600080fd5b600160a060020a0383166000908152602081905260409020546113b5908263ffffffff61133b16565b600160a060020a0380851660009081526020819052604080822093909355908416815220546113ea908263ffffffff61144916565b600160a060020a0380841660008181526020819052604090819020939093559151908516907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9061143c9085906119a9565b60405180910390a3505050565b60008282018381101561145b57600080fd5b9392505050565b600160a060020a038216151561147757600080fd5b600160a060020a03821660009081526020819052604090205481111561149c57600080fd5b6002546114af908263ffffffff61133b16565b600255600160a060020a0382166000908152602081905260409020546114db908263ffffffff61133b16565b600160a060020a0383166000818152602081905260408082209390935591517fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef906115279085906119a9565b60405180910390a35050565b600160a060020a038216600090815260016020908152604080832033845290915290205481111561156357600080fd5b600160a060020a0382166000908152600160209081526040808320338452909152902054611597908263ffffffff61133b16565b600160a060020a0383166000908152600160209081526040808320338452909152902055610ad18282611462565b600160a060020a03811615156115da57600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b604080518082019091526000808252602082015290565b600061145b82356119ec565b600080601f8301841361167857600080fd5b50813567ffffffffffffffff81111561169057600080fd5b6020830191508360208202830111156116a857600080fd5b9250929050565b600061145b82356119fd565b6000602082840312156116cd57600080fd5b6000610810848461165a565b600080604083850312156116ec57600080fd5b60006116f8858561165a565b92505060206117098582860161165a565b9150509250929050565b60008060006060848603121561172857600080fd5b6000611734868661165a565b93505060206117458682870161165a565b9250506040611756868287016116af565b9150509250925092565b6000806040838503121561177357600080fd5b600061177f858561165a565b9250506020611709858286016116af565b6000806000606084860312156117a557600080fd5b60006117b1868661165a565b9350506020611745868287016116af565b600080602083850312156117d557600080fd5b823567ffffffffffffffff8111156117ec57600080fd5b6117f885828601611666565b92509250509250929050565b6000806000806040858703121561181a57600080fd5b843567ffffffffffffffff81111561183157600080fd5b61183d87828801611666565b9450945050602085013567ffffffffffffffff81111561185c57600080fd5b61186887828801611666565b95989497509550505050565b60006020828403121561188657600080fd5b600061081084846116af565b600080604083850312156118a557600080fd5b600061177f85856116af565b6118ba816119ec565b82525050565b6118ba816119f8565b6118ba816119fd565b60006118dd826119e8565b8084526118f1816020860160208601611a00565b6118fa81611a30565b9093016020019392505050565b602b81527f4572726f723a207072656d69756d20737562736372697074696f6e206973207360208201527f74696c6c20616374697665000000000000000000000000000000000000000000604082015260600190565b601981527f4572726f723a20696e73756666696369656e742066756e647300000000000000602082015260400190565b6020810161053382846118b1565b6020810161053382846118c0565b6020810161053382846118c9565b6020808252810161145b81846118d2565b6020808252810161053381611907565b602080825281016105338161195d565b5190565b600160a060020a031690565b151590565b90565b60005b83811015611a1b578181015183820152602001611a03565b83811115611a2a576000848401525b50505050565b601f01601f1916905600a265627a7a7230582096344800243200ea5b42b37be26acb55fc8ec96801c4119ec15316d8f78379016c6578706572696d656e74616cf50037";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BATCHDELETEPREMIUMSUBSCRIPTIONTYPES = "batchDeletePremiumSubscriptionTypes";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_GETPREMIUMSUBSCRIPTIONPRICEPERDAY = "getPremiumSubscriptionPricePerDay";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_CHECKPREMIUMSUBSCRIPTION = "checkPremiumSubscription";

    public static final String FUNC_DELETEPREMIUMSUBSCRIPTIONTYPE = "deletePremiumSubscriptionType";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BATCHADDPREMIUMSUBSCRIPTIONTYPES = "batchAddPremiumSubscriptionTypes";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_UINTTOBYTES = "uintToBytes";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_ADDPREMIUMSUBSCRIPTIONTYPE = "addPremiumSubscriptionType";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_BATCHEDITPREMIUMSUBSCRIPTIONTYPES = "batchEditPremiumSubscriptionTypes";

    public static final String FUNC_GRANTPREMIUMSUBSCRIPTION = "grantPremiumSubscription";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_BUYPREMIUMSUBSCRIPTION = "buyPremiumSubscription";

    public static final String FUNC_UINTTOSTRING = "uintToString";

    public static final String FUNC_EDITPREMIUMSUBSCRIPTIONTYPE = "editPremiumSubscriptionType";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT = new Event("AddPremiumSubscriptionTypeEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT = new Event("EditPremiumSubscriptionTypeEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT = new Event("DeletePremiumSubscriptionTypeEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPRENOUNCED_EVENT = new Event("OwnershipRenounced", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected PremiumSubscriptionToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PremiumSubscriptionToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PremiumSubscriptionToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PremiumSubscriptionToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> approve(String spender, BigInteger value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> batchDeletePremiumSubscriptionTypes(List<BigInteger> _premiumSubscriptionTypeIds) {
        final Function function = new Function(
                FUNC_BATCHDELETEPREMIUMSUBSCRIPTIONTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionTypeIds, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getPremiumSubscriptionPricePerDay(BigInteger _premiumSubscriptionTypeId) {
        final Function function = new Function(FUNC_GETPREMIUMSUBSCRIPTIONPRICEPERDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String from, String to, BigInteger value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> checkPremiumSubscription(String _user, BigInteger _premiumSubscriptionTypeId) {
        final Function function = new Function(FUNC_CHECKPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> deletePremiumSubscriptionType(BigInteger _premiumSubscriptionTypeId) {
        final Function function = new Function(
                FUNC_DELETEPREMIUMSUBSCRIPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final Function function = new Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> burn(BigInteger value) {
        final Function function = new Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> batchAddPremiumSubscriptionTypes(List<BigInteger> _premiumSubscriptionTypeIds, List<BigInteger> _premiumSubscriptionPricesPerDay) {
        final Function function = new Function(
                FUNC_BATCHADDPREMIUMSUBSCRIPTIONTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionTypeIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionPricesPerDay, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> burnFrom(String from, BigInteger value) {
        final Function function = new Function(
                FUNC_BURNFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> bytes32ToString(byte[] x) {
        final Function function = new Function(FUNC_BYTES32TOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(x)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> uintToBytes(BigInteger v) {
        final Function function = new Function(FUNC_UINTTOBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(v)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addPremiumSubscriptionType(BigInteger _premiumSubscriptionTypeId, BigInteger _premiumSubscriptionPricePerDay) {
        final Function function = new Function(
                FUNC_ADDPREMIUMSUBSCRIPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionPricePerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transfer(String to, BigInteger value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> batchEditPremiumSubscriptionTypes(List<BigInteger> _premiumSubscriptionTypeIds, List<BigInteger> _premiumSubscriptionPricesPerDay) {
        final Function function = new Function(
                FUNC_BATCHEDITPREMIUMSUBSCRIPTIONTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionTypeIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionPricesPerDay, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> grantPremiumSubscription(String _user, BigInteger _days, BigInteger _premiumSubscriptionTypeId) {
        final Function function = new Function(
                FUNC_GRANTPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_days), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String owner, String spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> buyPremiumSubscription(BigInteger _days, BigInteger _premiumSubscriptionTypeId) {
        final Function function = new Function(
                FUNC_BUYPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_days), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> uintToString(BigInteger v) {
        final Function function = new Function(FUNC_UINTTOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(v)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> editPremiumSubscriptionType(BigInteger _premiumSubscriptionTypeId, BigInteger _premiumSubscriptionPricePerDay) {
        final Function function = new Function(
                FUNC_EDITPREMIUMSUBSCRIPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionPricePerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<AddPremiumSubscriptionTypeEventEventResponse> getAddPremiumSubscriptionTypeEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, transactionReceipt);
        ArrayList<AddPremiumSubscriptionTypeEventEventResponse> responses = new ArrayList<AddPremiumSubscriptionTypeEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddPremiumSubscriptionTypeEventEventResponse typedResponse = new AddPremiumSubscriptionTypeEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddPremiumSubscriptionTypeEventEventResponse> addPremiumSubscriptionTypeEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddPremiumSubscriptionTypeEventEventResponse>() {
            @Override
            public AddPremiumSubscriptionTypeEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, log);
                AddPremiumSubscriptionTypeEventEventResponse typedResponse = new AddPremiumSubscriptionTypeEventEventResponse();
                typedResponse.log = log;
                typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AddPremiumSubscriptionTypeEventEventResponse> addPremiumSubscriptionTypeEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT));
        return addPremiumSubscriptionTypeEventEventObservable(filter);
    }

    public List<EditPremiumSubscriptionTypeEventEventResponse> getEditPremiumSubscriptionTypeEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, transactionReceipt);
        ArrayList<EditPremiumSubscriptionTypeEventEventResponse> responses = new ArrayList<EditPremiumSubscriptionTypeEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EditPremiumSubscriptionTypeEventEventResponse typedResponse = new EditPremiumSubscriptionTypeEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<EditPremiumSubscriptionTypeEventEventResponse> editPremiumSubscriptionTypeEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, EditPremiumSubscriptionTypeEventEventResponse>() {
            @Override
            public EditPremiumSubscriptionTypeEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, log);
                EditPremiumSubscriptionTypeEventEventResponse typedResponse = new EditPremiumSubscriptionTypeEventEventResponse();
                typedResponse.log = log;
                typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<EditPremiumSubscriptionTypeEventEventResponse> editPremiumSubscriptionTypeEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT));
        return editPremiumSubscriptionTypeEventEventObservable(filter);
    }

    public List<DeletePremiumSubscriptionTypeEventEventResponse> getDeletePremiumSubscriptionTypeEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, transactionReceipt);
        ArrayList<DeletePremiumSubscriptionTypeEventEventResponse> responses = new ArrayList<DeletePremiumSubscriptionTypeEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DeletePremiumSubscriptionTypeEventEventResponse typedResponse = new DeletePremiumSubscriptionTypeEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DeletePremiumSubscriptionTypeEventEventResponse> deletePremiumSubscriptionTypeEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DeletePremiumSubscriptionTypeEventEventResponse>() {
            @Override
            public DeletePremiumSubscriptionTypeEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, log);
                DeletePremiumSubscriptionTypeEventEventResponse typedResponse = new DeletePremiumSubscriptionTypeEventEventResponse();
                typedResponse.log = log;
                typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DeletePremiumSubscriptionTypeEventEventResponse> deletePremiumSubscriptionTypeEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT));
        return deletePremiumSubscriptionTypeEventEventObservable(filter);
    }

    public List<OwnershipRenouncedEventResponse> getOwnershipRenouncedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPRENOUNCED_EVENT, transactionReceipt);
        ArrayList<OwnershipRenouncedEventResponse> responses = new ArrayList<OwnershipRenouncedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipRenouncedEventResponse typedResponse = new OwnershipRenouncedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipRenouncedEventResponse> ownershipRenouncedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipRenouncedEventResponse>() {
            @Override
            public OwnershipRenouncedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPRENOUNCED_EVENT, log);
                OwnershipRenouncedEventResponse typedResponse = new OwnershipRenouncedEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipRenouncedEventResponse> ownershipRenouncedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPRENOUNCED_EVENT));
        return ownershipRenouncedEventObservable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    public static RemoteCall<PremiumSubscriptionToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PremiumSubscriptionToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PremiumSubscriptionToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PremiumSubscriptionToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PremiumSubscriptionToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PremiumSubscriptionToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PremiumSubscriptionToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PremiumSubscriptionToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static PremiumSubscriptionToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PremiumSubscriptionToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PremiumSubscriptionToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PremiumSubscriptionToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PremiumSubscriptionToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PremiumSubscriptionToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PremiumSubscriptionToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PremiumSubscriptionToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class AddPremiumSubscriptionTypeEventEventResponse {
        public Log log;

        public BigInteger _premiumSubscriptionTypeId;
    }

    public static class EditPremiumSubscriptionTypeEventEventResponse {
        public Log log;

        public BigInteger _premiumSubscriptionTypeId;
    }

    public static class DeletePremiumSubscriptionTypeEventEventResponse {
        public Log log;

        public BigInteger _premiumSubscriptionTypeId;
    }

    public static class OwnershipRenouncedEventResponse {
        public Log log;

        public String previousOwner;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }
}
