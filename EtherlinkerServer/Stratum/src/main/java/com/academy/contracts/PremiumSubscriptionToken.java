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
    private static final String BINARY = "608060405260038054600160a060020a03191633179055611638806100256000396000f3006080604052600436106101325763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663095ea7b3811461013757806318160ddd1461016d5780631c1c641d1461018f57806323b872dd146101af57806327de2f8d146101cf57806331ecad66146101ef578063395093511461021157806342966c681461023157806370a0823114610251578063715018a61461027157806379cc6790146102865780638da5cb5b146102a65780639201de55146102c857806394e8767d146102f5578063a457c2d714610315578063a4faf09f14610335578063a9059cbb14610355578063cd05553114610375578063dd62ed3e14610395578063e2cee85e146103b5578063e9395679146103d5578063f2a90b4b146103f5578063f2fde38b14610415575b600080fd5b34801561014357600080fd5b506101576101523660046113d6565b610435565b604051610164919061155f565b60405180910390f35b34801561017957600080fd5b506101826104b8565b604051610164919061156d565b34801561019b57600080fd5b506101826101aa366004611438565b6104be565b3480156101bb57600080fd5b506101576101ca366004611389565b6104d3565b3480156101db57600080fd5b506101576101ea3660046113d6565b610570565b3480156101fb57600080fd5b5061020f61020a366004611438565b6106e9565b005b34801561021d57600080fd5b5061015761022c3660046113d6565b610752565b34801561023d57600080fd5b5061020f61024c366004611438565b6107f5565b34801561025d57600080fd5b5061018261026c366004611331565b610802565b34801561027d57600080fd5b5061020f61081d565b34801561029257600080fd5b5061020f6102a13660046113d6565b61088b565b3480156102b257600080fd5b506102bb610899565b6040516101649190611551565b3480156102d457600080fd5b506102e86102e3366004611438565b6108a8565b604051610164919061157b565b34801561030157600080fd5b50610182610310366004611438565b610a1e565b34801561032157600080fd5b506101576103303660046113d6565b610a7c565b34801561034157600080fd5b5061020f610350366004611456565b610ac7565b34801561036157600080fd5b506101576103703660046113d6565b610b51565b34801561038157600080fd5b5061020f610390366004611406565b610b67565b3480156103a157600080fd5b506101826103b036600461134f565b610d1d565b3480156103c157600080fd5b5061020f6103d0366004611456565b610d48565b3480156103e157600080fd5b506102e86103f0366004611438565b610f4f565b34801561040157600080fd5b5061020f610410366004611456565b610f5d565b34801561042157600080fd5b5061020f610430366004611331565b610fda565b6000600160a060020a038316151561044c57600080fd5b336000818152600160209081526040808320600160a060020a03881680855292529182902085905590519091907f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925906104a690869061156d565b60405180910390a35060015b92915050565b60025490565b60009081526005602052604090206001015490565b600160a060020a038316600090815260016020908152604080832033845290915281205482111561050357600080fd5b600160a060020a0384166000908152600160209081526040808320338452909152902054610537908363ffffffff610ffa16565b600160a060020a0385166000908152600160209081526040808320338452909152902055610566848484611011565b5060019392505050565b600060608361057e84610f4f565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b602083106105d75780518252601f1990920191602091820191016105b8565b6001836020036101000a0380198251168184511680821785525050505050509050019250505060405160208183030381529060405290506004816040518082805190602001908083835b602083106106405780518252601f199092019160209182019101610621565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092205442108015925090506106e157506004816040518082805190602001908083835b602083106106ab5780518252601f19909201916020918201910161068c565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220600101544211159150505b949350505050565b600354600160a060020a0316331461070057600080fd5b60008181526005602052604080822082815560010191909155517fa51c5188e1948c771c5869a9d2c919518028dc8e3c947dd22fd3ae13aeda4c4a9061074790839061156d565b60405180910390a150565b6000600160a060020a038316151561076957600080fd5b336000908152600160209081526040808320600160a060020a038716845290915290205461079d908363ffffffff61110816565b336000818152600160209081526040808320600160a060020a038916808552925291829020849055905190927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925916104a6919061156d565b6107ff3382611121565b50565b600160a060020a031660009081526020819052604090205490565b600354600160a060020a0316331461083457600080fd5b600354604051600160a060020a03909116907ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482090600090a26003805473ffffffffffffffffffffffffffffffffffffffff19169055565b61089582826111f2565b5050565b600354600160a060020a031681565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b602083101561096c576008830260020a870291507fff000000000000000000000000000000000000000000000000000000000000008216156109615781858581518110151561092a57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001909301925b6001909201916108df565b836040519080825280601f01601f19166020018201604052801561099a578160200160208202803883390190505b509050600092505b83831015610a145784838151811015156109b857fe5b90602001015160f860020a900460f860020a0281848151811015156109d957fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001909201916109a2565b9695505050505050565b6000811515610a4e57507f3000000000000000000000000000000000000000000000000000000000000000610a77565b6000821115610a775761010081049050600a820660300160f860020a0217600a82049150610a4e565b919050565b6000600160a060020a0383161515610a9357600080fd5b336000908152600160209081526040808320600160a060020a038716845290915290205461079d908363ffffffff610ffa16565b610acf611302565b600354600160a060020a03163314610ae657600080fd5b506040805180820182528381526020808201848152600086815260059092529083902082518155905160019091015590517f2bf5da1e90f7b3234642edd1283811b71e4130202f7f9024b5b260ae536af5df90610b4490859061156d565b60405180910390a1505050565b6000610b5e338484611011565b50600192915050565b610b6f611302565b600354606090600160a060020a03163314610b8957600080fd5b6000838152600560205260409020541515610ba357600080fd5b610bad8584610570565b15610bed576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610be49061158c565b60405180910390fd5b6040805180820190915242808252620151808602016020820152915084610c1384610f4f565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b60208310610c6c5780518252601f199092019160209182019101610c4d565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040529050816004826040518082805190602001908083835b60208310610cd65780518252601f199092019160209182019101610cb7565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084518155939092015160019093019290925550505050505050565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b610d50611302565b6000828152600560205260409020546060901515610d6d57600080fd5b6000838152600560205260409020600101548402610d8a33610802565b1015610dc2576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610be49061159c565b610dcc3384610570565b15610e03576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610be49061158c565b600083815260056020526040902060010154610e209085026107f5565b6040805180820190915242808252620151808602016020820152915033610e4684610f4f565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b60208310610e9f5780518252601f199092019160209182019101610e80565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040529050816004826040518082805190602001908083835b60208310610f095780518252601f199092019160209182019101610eea565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845181559390920151600190930192909255505050505050565b60606104b26102e383610a1e565b610f65611302565b600354600160a060020a03163314610f7c57600080fd5b506040805180820182528381526020808201848152600086815260059092529083902082518155905160019091015590517f99e5fc2422da5e949a914149894c1b8cb972a4edec220e66c58a5968a668dc0d90610b4490859061156d565b600354600160a060020a03163314610ff157600080fd5b6107ff81611284565b6000808383111561100a57600080fd5b5050900390565b600160a060020a03831660009081526020819052604090205481111561103657600080fd5b600160a060020a038216151561104b57600080fd5b600160a060020a038316600090815260208190526040902054611074908263ffffffff610ffa16565b600160a060020a0380851660009081526020819052604080822093909355908416815220546110a9908263ffffffff61110816565b600160a060020a0380841660008181526020819052604090819020939093559151908516907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef906110fb90859061156d565b60405180910390a3505050565b60008282018381101561111a57600080fd5b9392505050565b600160a060020a038216151561113657600080fd5b600160a060020a03821660009081526020819052604090205481111561115b57600080fd5b60025461116e908263ffffffff610ffa16565b600255600160a060020a03821660009081526020819052604090205461119a908263ffffffff610ffa16565b600160a060020a0383166000818152602081905260408082209390935591517fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef906111e690859061156d565b60405180910390a35050565b600160a060020a038216600090815260016020908152604080832033845290915290205481111561122257600080fd5b600160a060020a0382166000908152600160209081526040808320338452909152902054611256908263ffffffff610ffa16565b600160a060020a03831660009081526001602090815260408083203384529091529020556108958282611121565b600160a060020a038116151561129957600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b604080518082019091526000808252602082015290565b600061111a82356115b0565b600061111a82356115c1565b60006020828403121561134357600080fd5b60006106e18484611319565b6000806040838503121561136257600080fd5b600061136e8585611319565b925050602061137f85828601611319565b9150509250929050565b60008060006060848603121561139e57600080fd5b60006113aa8686611319565b93505060206113bb86828701611319565b92505060406113cc86828701611325565b9150509250925092565b600080604083850312156113e957600080fd5b60006113f58585611319565b925050602061137f85828601611325565b60008060006060848603121561141b57600080fd5b60006114278686611319565b93505060206113bb86828701611325565b60006020828403121561144a57600080fd5b60006106e18484611325565b6000806040838503121561146957600080fd5b60006113f58585611325565b61147e816115b0565b82525050565b61147e816115bc565b61147e816115c1565b60006114a1826115ac565b8084526114b58160208601602086016115c4565b6114be816115f4565b9093016020019392505050565b602b81527f4572726f723a207072656d69756d20737562736372697074696f6e206973207360208201527f74696c6c20616374697665000000000000000000000000000000000000000000604082015260600190565b601981527f4572726f723a20696e73756666696369656e742066756e647300000000000000602082015260400190565b602081016104b28284611475565b602081016104b28284611484565b602081016104b2828461148d565b6020808252810161111a8184611496565b602080825281016104b2816114cb565b602080825281016104b281611521565b5190565b600160a060020a031690565b151590565b90565b60005b838110156115df5781810151838201526020016115c7565b838111156115ee576000848401525b50505050565b601f01601f1916905600a265627a7a723058202d88acba48efa8391a0d815e7333dc8149713f73286641d894a777d7df2e35766c6578706572696d656e74616cf50037";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_GETPREMIUMSUBSCRIPTIONPRICEPERDAY = "getPremiumSubscriptionPricePerDay";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_CHECKPREMIUMSUBSCRIPTION = "checkPremiumSubscription";

    public static final String FUNC_DELETEPREMIUMSUBSCRIPTIONTYPE = "deletePremiumSubscriptionType";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_UINTTOBYTES = "uintToBytes";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_ADDPREMIUMSUBSCRIPTIONTYPE = "addPremiumSubscriptionType";

    public static final String FUNC_TRANSFER = "transfer";

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
