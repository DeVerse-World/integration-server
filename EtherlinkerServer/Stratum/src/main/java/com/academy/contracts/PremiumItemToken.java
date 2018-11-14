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
public class PremiumItemToken extends Contract {
    private static final String BINARY = "608060405260038054600160a060020a03191633179055610d8d806100256000396000f3006080604052600436106101115763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663095ea7b3811461011657806318160ddd1461014e57806323b872dd1461017557806324d9dcad1461019f57806339509351146101bc5780633a2dc679146101e057806342966c68146101fb5780634faf180c146102135780636af3bfce1461022b57806370a082311461024f578063715018a61461027057806379cc6790146102855780638da5cb5b146102a9578063a457c2d7146102da578063a9059cbb146102fe578063bb714a1f14610322578063d40a557f14610346578063dd62ed3e1461035e578063f2fde38b14610385578063f3cb5438146103a6575b600080fd5b34801561012257600080fd5b5061013a600160a060020a03600435166024356103be565b604080519115158252519081900360200190f35b34801561015a57600080fd5b5061016361043c565b60408051918252519081900360200190f35b34801561018157600080fd5b5061013a600160a060020a0360043581169060243516604435610442565b3480156101ab57600080fd5b506101ba6004356024356104df565b005b3480156101c857600080fd5b5061013a600160a060020a0360043516602435610564565b3480156101ec57600080fd5b506101ba600435602435610614565b34801561020757600080fd5b506101ba600435610699565b34801561021f57600080fd5b506101ba6004356106a6565b34801561023757600080fd5b5061013a600160a060020a0360043516602435610811565b34801561025b57600080fd5b50610163600160a060020a0360043516610830565b34801561027c57600080fd5b506101ba61084b565b34801561029157600080fd5b506101ba600160a060020a03600435166024356108b9565b3480156102b557600080fd5b506102be6108c7565b60408051600160a060020a039092168252519081900360200190f35b3480156102e657600080fd5b5061013a600160a060020a03600435166024356108d6565b34801561030a57600080fd5b5061013a600160a060020a0360043516602435610921565b34801561032e57600080fd5b506101ba600160a060020a0360043516602435610937565b34801561035257600080fd5b50610163600435610984565b34801561036a57600080fd5b50610163600160a060020a0360043581169060243516610999565b34801561039157600080fd5b506101ba600160a060020a03600435166109c4565b3480156103b257600080fd5b506101ba6004356109e4565b6000600160a060020a03831615156103d557600080fd5b336000818152600160209081526040808320600160a060020a03881680855290835292819020869055805186815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a350600192915050565b60025490565b600160a060020a038316600090815260016020908152604080832033845290915281205482111561047257600080fd5b600160a060020a03841660009081526001602090815260408083203384529091529020546104a6908363ffffffff610a4a16565b600160a060020a03851660009081526001602090815260408083203384529091529020556104d5848484610a61565b5060019392505050565b6104e7610d4a565b600354600160a060020a031633146104fe57600080fd5b5060408051808201825283815260208082018481526000868152600583528490208351815590516001909101558251858152925191927f5f9c2ea8b2ea07dceb39996762bb28af4cc5ed42e4b4ac84c3432bcb9ae06368929081900390910190a1505050565b6000600160a060020a038316151561057b57600080fd5b336000908152600160209081526040808320600160a060020a03871684529091529020546105af908363ffffffff610b5316565b336000818152600160209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b61061c610d4a565b600354600160a060020a0316331461063357600080fd5b5060408051808201825283815260208082018481526000868152600583528490208351815590516001909101558251858152925191927f324840da1b07686a48ba5e392904b4ce809de98ec4a720311da7286d913cdf79929081900390910190a1505050565b6106a33382610b6c565b50565b60008181526005602052604090205415156106c057600080fd5b6000818152600560205260409020600101546106db33610830565b101561074857604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f4572726f723a20696e73756666696369656e742066756e647300000000000000604482015290519081900360640190fd5b6107523382610811565b156107e457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602160248201527f4572726f723a207072656d69756d206974656d20616c7265616479206f776e6560448201527f6400000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b6000818152600560205260409020600101546107ff90610699565b33600090815260046020526040902055565b600160a060020a03919091166000908152600460205260409020541490565b600160a060020a031660009081526020819052604090205490565b600354600160a060020a0316331461086257600080fd5b600354604051600160a060020a03909116907ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482090600090a26003805473ffffffffffffffffffffffffffffffffffffffff19169055565b6108c38282610c3a565b5050565b600354600160a060020a031681565b6000600160a060020a03831615156108ed57600080fd5b336000908152600160209081526040808320600160a060020a03871684529091529020546105af908363ffffffff610a4a16565b600061092e338484610a61565b50600192915050565b600354600160a060020a0316331461094e57600080fd5b600081815260056020526040902054151561096857600080fd5b600160a060020a03909116600090815260046020526040902055565b60009081526005602052604090206001015490565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b600354600160a060020a031633146109db57600080fd5b6106a381610ccc565b600354600160a060020a031633146109fb57600080fd5b600081815260056020908152604080832083815560010192909255815183815291517f0e37a5803a75db34b651d4e8b54e6454320dc026c797d41dc7e136b0033582bc9281900390910190a150565b60008083831115610a5a57600080fd5b5050900390565b600160a060020a038316600090815260208190526040902054811115610a8657600080fd5b600160a060020a0382161515610a9b57600080fd5b600160a060020a038316600090815260208190526040902054610ac4908263ffffffff610a4a16565b600160a060020a038085166000908152602081905260408082209390935590841681522054610af9908263ffffffff610b5316565b600160a060020a038084166000818152602081815260409182902094909455805185815290519193928716927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef92918290030190a3505050565b600082820183811015610b6557600080fd5b9392505050565b600160a060020a0382161515610b8157600080fd5b600160a060020a038216600090815260208190526040902054811115610ba657600080fd5b600254610bb9908263ffffffff610a4a16565b600255600160a060020a038216600090815260208190526040902054610be5908263ffffffff610a4a16565b600160a060020a038316600081815260208181526040808320949094558351858152935191937fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929081900390910190a35050565b600160a060020a0382166000908152600160209081526040808320338452909152902054811115610c6a57600080fd5b600160a060020a0382166000908152600160209081526040808320338452909152902054610c9e908263ffffffff610a4a16565b600160a060020a03831660009081526001602090815260408083203384529091529020556108c38282610b6c565b600160a060020a0381161515610ce157600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6040805180820190915260008082526020820152905600a165627a7a72305820220c2c4ed414979a6c9afcb1dbc36b11d40c8f51408b12f9aef5f4ca7273d8c90029";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_EDITPREMIUMITEM = "editPremiumItem";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_ADDPREMIUMITEM = "addPremiumItem";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BUYPREMIUMITEM = "buyPremiumItem";

    public static final String FUNC_CHECKPREMIUMITEM = "checkPremiumItem";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_GRANTPREMIUMITEM = "grantPremiumItem";

    public static final String FUNC_GETPREMIUMITEMPRICE = "getPremiumItemPrice";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DELETEPREMIUMITEM = "deletePremiumItem";

    public static final Event ADDPREMIUMITEMEVENT_EVENT = new Event("AddPremiumItemEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event EDITPREMIUMITEMEVENT_EVENT = new Event("EditPremiumItemEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event DELETEPREMIUMITEMEVENT_EVENT = new Event("DeletePremiumItemEvent", 
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
    protected PremiumItemToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PremiumItemToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PremiumItemToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PremiumItemToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<TransactionReceipt> transferFrom(String from, String to, BigInteger value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> editPremiumItem(BigInteger _itemId, BigInteger _itemPrice) {
        final Function function = new Function(
                FUNC_EDITPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemPrice)), 
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

    public RemoteCall<TransactionReceipt> addPremiumItem(BigInteger _itemId, BigInteger _itemPrice) {
        final Function function = new Function(
                FUNC_ADDPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemPrice)), 
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

    public RemoteCall<TransactionReceipt> buyPremiumItem(BigInteger _itemId) {
        final Function function = new Function(
                FUNC_BUYPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> checkPremiumItem(String _user, BigInteger _itemId) {
        final Function function = new Function(FUNC_CHECKPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
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

    public RemoteCall<TransactionReceipt> grantPremiumItem(String _user, BigInteger _itemId) {
        final Function function = new Function(
                FUNC_GRANTPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getPremiumItemPrice(BigInteger _itemId) {
        final Function function = new Function(FUNC_GETPREMIUMITEMPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> allowance(String owner, String spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> deletePremiumItem(BigInteger _itemId) {
        final Function function = new Function(
                FUNC_DELETEPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<AddPremiumItemEventEventResponse> getAddPremiumItemEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDPREMIUMITEMEVENT_EVENT, transactionReceipt);
        ArrayList<AddPremiumItemEventEventResponse> responses = new ArrayList<AddPremiumItemEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddPremiumItemEventEventResponse typedResponse = new AddPremiumItemEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddPremiumItemEventEventResponse> addPremiumItemEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddPremiumItemEventEventResponse>() {
            @Override
            public AddPremiumItemEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDPREMIUMITEMEVENT_EVENT, log);
                AddPremiumItemEventEventResponse typedResponse = new AddPremiumItemEventEventResponse();
                typedResponse.log = log;
                typedResponse._itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AddPremiumItemEventEventResponse> addPremiumItemEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDPREMIUMITEMEVENT_EVENT));
        return addPremiumItemEventEventObservable(filter);
    }

    public List<EditPremiumItemEventEventResponse> getEditPremiumItemEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EDITPREMIUMITEMEVENT_EVENT, transactionReceipt);
        ArrayList<EditPremiumItemEventEventResponse> responses = new ArrayList<EditPremiumItemEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EditPremiumItemEventEventResponse typedResponse = new EditPremiumItemEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<EditPremiumItemEventEventResponse> editPremiumItemEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, EditPremiumItemEventEventResponse>() {
            @Override
            public EditPremiumItemEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EDITPREMIUMITEMEVENT_EVENT, log);
                EditPremiumItemEventEventResponse typedResponse = new EditPremiumItemEventEventResponse();
                typedResponse.log = log;
                typedResponse._itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<EditPremiumItemEventEventResponse> editPremiumItemEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EDITPREMIUMITEMEVENT_EVENT));
        return editPremiumItemEventEventObservable(filter);
    }

    public List<DeletePremiumItemEventEventResponse> getDeletePremiumItemEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DELETEPREMIUMITEMEVENT_EVENT, transactionReceipt);
        ArrayList<DeletePremiumItemEventEventResponse> responses = new ArrayList<DeletePremiumItemEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DeletePremiumItemEventEventResponse typedResponse = new DeletePremiumItemEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DeletePremiumItemEventEventResponse> deletePremiumItemEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DeletePremiumItemEventEventResponse>() {
            @Override
            public DeletePremiumItemEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELETEPREMIUMITEMEVENT_EVENT, log);
                DeletePremiumItemEventEventResponse typedResponse = new DeletePremiumItemEventEventResponse();
                typedResponse.log = log;
                typedResponse._itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DeletePremiumItemEventEventResponse> deletePremiumItemEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETEPREMIUMITEMEVENT_EVENT));
        return deletePremiumItemEventEventObservable(filter);
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

    public static RemoteCall<PremiumItemToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PremiumItemToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PremiumItemToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PremiumItemToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PremiumItemToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PremiumItemToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PremiumItemToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PremiumItemToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static PremiumItemToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PremiumItemToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PremiumItemToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PremiumItemToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PremiumItemToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PremiumItemToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PremiumItemToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PremiumItemToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class AddPremiumItemEventEventResponse {
        public Log log;

        public BigInteger _itemId;
    }

    public static class EditPremiumItemEventEventResponse {
        public Log log;

        public BigInteger _itemId;
    }

    public static class DeletePremiumItemEventEventResponse {
        public Log log;

        public BigInteger _itemId;
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
