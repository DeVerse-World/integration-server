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
    private static final String BINARY = "608060405260038054600160a060020a031916331790556110e6806100256000396000f3006080604052600436106101325763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663095ea7b3811461013757806318160ddd1461016f57806323b872dd1461019657806324d9dcad146101c057806339509351146101dd5780633a2dc6791461020157806342966c681461021c5780634faf180c146102345780636af3bfce1461024c57806370a0823114610270578063715018a614610291578063761232e0146102a657806379cc6790146102d25780637e553156146102f65780638da5cb5b14610322578063a457c2d714610353578063a9059cbb14610377578063bb714a1f1461039b578063d40a557f146103bf578063dd62ed3e146103d7578063f2fde38b146103fe578063f3cb54381461041f578063f7d26c8414610437575b600080fd5b34801561014357600080fd5b5061015b600160a060020a0360043516602435610457565b604080519115158252519081900360200190f35b34801561017b57600080fd5b506101846104d5565b60408051918252519081900360200190f35b3480156101a257600080fd5b5061015b600160a060020a03600435811690602435166044356104db565b3480156101cc57600080fd5b506101db600435602435610578565b005b3480156101e957600080fd5b5061015b600160a060020a03600435166024356105fd565b34801561020d57600080fd5b506101db6004356024356106ad565b34801561022857600080fd5b506101db600435610732565b34801561024057600080fd5b506101db60043561073f565b34801561025857600080fd5b5061015b600160a060020a03600435166024356108aa565b34801561027c57600080fd5b50610184600160a060020a03600435166108c9565b34801561029d57600080fd5b506101db6108e4565b3480156102b257600080fd5b506101db6024600480358281019290820135918135918201910135610952565b3480156102de57600080fd5b506101db600160a060020a0360043516602435610a5f565b34801561030257600080fd5b506101db6024600480358281019290820135918135918201910135610a6d565b34801561032e57600080fd5b50610337610b72565b60408051600160a060020a039092168252519081900360200190f35b34801561035f57600080fd5b5061015b600160a060020a0360043516602435610b81565b34801561038357600080fd5b5061015b600160a060020a0360043516602435610bcc565b3480156103a757600080fd5b506101db600160a060020a0360043516602435610be2565b3480156103cb57600080fd5b50610184600435610c2f565b3480156103e357600080fd5b50610184600160a060020a0360043581169060243516610c44565b34801561040a57600080fd5b506101db600160a060020a0360043516610c6f565b34801561042b57600080fd5b506101db600435610c8f565b34801561044357600080fd5b506101db6004803560248101910135610cf5565b6000600160a060020a038316151561046e57600080fd5b336000818152600160209081526040808320600160a060020a03881680855290835292819020869055805186815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a350600192915050565b60025490565b600160a060020a038316600090815260016020908152604080832033845290915281205482111561050b57600080fd5b600160a060020a038416600090815260016020908152604080832033845290915290205461053f908363ffffffff610da316565b600160a060020a038516600090815260016020908152604080832033845290915290205561056e848484610dba565b5060019392505050565b6105806110a3565b600354600160a060020a0316331461059757600080fd5b5060408051808201825283815260208082018481526000868152600583528490208351815590516001909101558251858152925191927f5f9c2ea8b2ea07dceb39996762bb28af4cc5ed42e4b4ac84c3432bcb9ae06368929081900390910190a1505050565b6000600160a060020a038316151561061457600080fd5b336000908152600160209081526040808320600160a060020a0387168452909152902054610648908363ffffffff610eac16565b336000818152600160209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b6106b56110a3565b600354600160a060020a031633146106cc57600080fd5b5060408051808201825283815260208082018481526000868152600583528490208351815590516001909101558251858152925191927f324840da1b07686a48ba5e392904b4ce809de98ec4a720311da7286d913cdf79929081900390910190a1505050565b61073c3382610ec5565b50565b600081815260056020526040902054151561075957600080fd5b600081815260056020526040902060010154610774336108c9565b10156107e157604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f4572726f723a20696e73756666696369656e742066756e647300000000000000604482015290519081900360640190fd5b6107eb33826108aa565b1561087d57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602160248201527f4572726f723a207072656d69756d206974656d20616c7265616479206f776e6560448201527f6400000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b60008181526005602052604090206001015461089890610732565b33600090815260046020526040902055565b600160a060020a03919091166000908152600460205260409020541490565b600160a060020a031660009081526020819052604090205490565b600354600160a060020a031633146108fb57600080fd5b600354604051600160a060020a03909116907ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482090600090a26003805473ffffffffffffffffffffffffffffffffffffffff19169055565b600061095c6110a3565b600354600160a060020a0316331461097357600080fd5b84831461097f57600080fd5b600091505b84821015610a575760408051808201909152808787858181106109a357fe5b90506020020135815260200185858581811015156109bd57fe5b905060200201358152509050806005600088888681811015156109dc57fe5b6020908102929092013583525081810192909252604001600020825181559101516001909101557f324840da1b07686a48ba5e392904b4ce809de98ec4a720311da7286d913cdf79868684818110610a3057fe5b905060200201356040518082815260200191505060405180910390a1600190910190610984565b505050505050565b610a698282610f93565b5050565b6000610a776110a3565b600354600160a060020a03163314610a8e57600080fd5b848314610a9a57600080fd5b600091505b84821015610a57576040805180820190915280878785818110610abe57fe5b9050602002013581526020018585858181101515610ad857fe5b90506020020135815250905080600560008888868181101515610af757fe5b6020908102929092013583525081810192909252604001600020825181559101516001909101557f5f9c2ea8b2ea07dceb39996762bb28af4cc5ed42e4b4ac84c3432bcb9ae06368868684818110610b4b57fe5b905060200201356040518082815260200191505060405180910390a1600190910190610a9f565b600354600160a060020a031681565b6000600160a060020a0383161515610b9857600080fd5b336000908152600160209081526040808320600160a060020a0387168452909152902054610648908363ffffffff610da316565b6000610bd9338484610dba565b50600192915050565b600354600160a060020a03163314610bf957600080fd5b6000818152600560205260409020541515610c1357600080fd5b600160a060020a03909116600090815260046020526040902055565b60009081526005602052604090206001015490565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b600354600160a060020a03163314610c8657600080fd5b61073c81611025565b600354600160a060020a03163314610ca657600080fd5b600081815260056020908152604080832083815560010192909255815183815291517f0e37a5803a75db34b651d4e8b54e6454320dc026c797d41dc7e136b0033582bc9281900390910190a150565b600354600090600160a060020a03163314610d0f57600080fd5b5060005b81811015610d9e5760056000848484818110610d2b57fe5b602090810292909201358352508101919091526040016000908120818155600101557f0e37a5803a75db34b651d4e8b54e6454320dc026c797d41dc7e136b0033582bc838383818110610d7a57fe5b905060200201356040518082815260200191505060405180910390a1600101610d13565b505050565b60008083831115610db357600080fd5b5050900390565b600160a060020a038316600090815260208190526040902054811115610ddf57600080fd5b600160a060020a0382161515610df457600080fd5b600160a060020a038316600090815260208190526040902054610e1d908263ffffffff610da316565b600160a060020a038085166000908152602081905260408082209390935590841681522054610e52908263ffffffff610eac16565b600160a060020a038084166000818152602081815260409182902094909455805185815290519193928716927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef92918290030190a3505050565b600082820183811015610ebe57600080fd5b9392505050565b600160a060020a0382161515610eda57600080fd5b600160a060020a038216600090815260208190526040902054811115610eff57600080fd5b600254610f12908263ffffffff610da316565b600255600160a060020a038216600090815260208190526040902054610f3e908263ffffffff610da316565b600160a060020a038316600081815260208181526040808320949094558351858152935191937fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929081900390910190a35050565b600160a060020a0382166000908152600160209081526040808320338452909152902054811115610fc357600080fd5b600160a060020a0382166000908152600160209081526040808320338452909152902054610ff7908263ffffffff610da316565b600160a060020a0383166000908152600160209081526040808320338452909152902055610a698282610ec5565b600160a060020a038116151561103a57600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6040805180820190915260008082526020820152905600a165627a7a72305820f84e2e6cb2874307aeae6d69b281fb0ec5812b7fecb9dd8c3f864d0fa8d5f5d80029";

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

    public static final String FUNC_BATCHADDPREMIUMITEMS = "batchAddPremiumItems";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_BATCHEDITPREMIUMITEMS = "batchEditPremiumItems";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_GRANTPREMIUMITEM = "grantPremiumItem";

    public static final String FUNC_GETPREMIUMITEMPRICE = "getPremiumItemPrice";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DELETEPREMIUMITEM = "deletePremiumItem";

    public static final String FUNC_BATCHDELETEPREMIUMITEMS = "batchDeletePremiumItems";

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

    public RemoteCall<TransactionReceipt> batchAddPremiumItems(List<BigInteger> _itemIds, List<BigInteger> _itemPrices) {
        final Function function = new Function(
                FUNC_BATCHADDPREMIUMITEMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_itemIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_itemPrices, org.web3j.abi.datatypes.generated.Uint256.class))), 
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

    public RemoteCall<TransactionReceipt> batchEditPremiumItems(List<BigInteger> _itemIds, List<BigInteger> _itemPrices) {
        final Function function = new Function(
                FUNC_BATCHEDITPREMIUMITEMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_itemIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_itemPrices, org.web3j.abi.datatypes.generated.Uint256.class))), 
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

    public RemoteCall<TransactionReceipt> batchDeletePremiumItems(List<BigInteger> _itemIds) {
        final Function function = new Function(
                FUNC_BATCHDELETEPREMIUMITEMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_itemIds, org.web3j.abi.datatypes.generated.Uint256.class))), 
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
