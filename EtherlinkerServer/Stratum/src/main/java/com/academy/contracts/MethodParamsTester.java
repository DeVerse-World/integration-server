package com.academy.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes1;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Int8;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.4.
 */
@SuppressWarnings("rawtypes")
public class MethodParamsTester extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610b9e806100206000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c806383d19ab41161008c578063985c4c4211610066578063985c4c42146101c5578063ac59c960146101e0578063cfae3217146101fb578063f225190714610203576100ea565b806383d19ab41461019757806392bd51fc146101b257806393bb62681461016e576100ea565b806352b696e4116100c857806352b696e4146101335780636a57db531461014e578063788e29f81461016e578063816fcff11461017c576100ea565b806306a2d5ac146100ef578063109cdfcd1461011857806322e51100146100ef575b600080fd5b6101026100fd36600461065f565b61021e565b60405161010f91906109df565b60405180910390f35b6101266100fd366004610584565b60405161010f91906109a1565b6101416100fd3660046105ee565b60405161010f91906109b2565b61016161015c3660046105b9565b610225565b60405161010f91906109ce565b6101616100fd36600461062a565b61018a6100fd36600461054f565b60405161010f9190610990565b6101a56100fd3660046106e2565b60405161010f91906109ed565b6101616101c036600461067d565b6102c1565b6101d36100fd366004610700565b60405161010f9190610a0b565b6101ee6100fd366004610529565b60405161010f9190610982565b61016161030f565b6102116100fd36600461060c565b60405161010f91906109c0565b805b919050565b6060604051602001610236906109fb565b604051602081830303815290604052805190602001208260008151811061025957fe5b602002602001015160405160200161027191906109ce565b6040516020818303038152906040528051906020012014156102b25760405160200161029c90610940565b6040516020818303038152906040529050610220565b60405160200161029c90610961565b6060828413156102d2575080610308565b5060408051808201909152601981527f696e70757456616c756532203c20696e70757456616c7565310000000000000060208201525b9392505050565b60408051808201909152601a81527f48656c6c6f20457468657265756d20426c6f636b636861696e21000000000000602082015290565b803561035181610b17565b92915050565b600082601f83011261036857600080fd5b813561037b61037682610a40565b610a19565b915081818352602084019350602081019050838560208402820111156103a057600080fd5b60005b838110156103cc57816103b688826104a3565b84525060209283019291909101906001016103a3565b5050505092915050565b600082601f8301126103e757600080fd5b81356103f561037682610a40565b9150818183526020840193506020810190508385602084028201111561041a57600080fd5b60005b838110156103cc57816104308882610508565b845250602092830192919091019060010161041d565b600082601f83011261045757600080fd5b813561046561037682610a40565b81815260209384019390925082018360005b838110156103cc578135860161048d88826104b9565b8452506020928301929190910190600101610477565b803561035181610b2e565b803561035181610b37565b600082601f8301126104ca57600080fd5b81356104d861037682610a61565b915080825260208301602083018583830111156104f457600080fd5b6104ff838284610ad1565b50505092915050565b803561035181610b40565b803561035181610b49565b803561035181610b52565b60006020828403121561053b57600080fd5b60006105478484610346565b949350505050565b60006020828403121561056157600080fd5b813567ffffffffffffffff81111561057857600080fd5b61054784828501610357565b60006020828403121561059657600080fd5b813567ffffffffffffffff8111156105ad57600080fd5b610547848285016103d6565b6000602082840312156105cb57600080fd5b813567ffffffffffffffff8111156105e257600080fd5b61054784828501610446565b60006020828403121561060057600080fd5b600061054784846104a3565b60006020828403121561061e57600080fd5b600061054784846104ae565b60006020828403121561063c57600080fd5b813567ffffffffffffffff81111561065357600080fd5b610547848285016104b9565b60006020828403121561067157600080fd5b60006105478484610508565b60008060006060848603121561069257600080fd5b600061069e8686610508565b93505060206106af86828701610508565b925050604084013567ffffffffffffffff8111156106cc57600080fd5b6106d8868287016104b9565b9150509250925092565b6000602082840312156106f457600080fd5b60006105478484610513565b60006020828403121561071257600080fd5b6000610547848461051e565b600061072a83836107f4565b505060200190565b600061072a838361083e565b61074781610a9c565b82525050565b600061075882610a8f565b6107628185610a93565b935061076d83610a89565b8060005b8381101561079b578151610785888261071e565b975061079083610a89565b925050600101610771565b509495945050505050565b60006107b182610a8f565b6107bb8185610a93565b93506107c683610a89565b8060005b8381101561079b5781516107de8882610732565b97506107e983610a89565b9250506001016107ca565b61074781610aa7565b61074781610aac565b600061081182610a8f565b61081b8185610a93565b935061082b818560208601610add565b61083481610b0d565b9093019392505050565b6107478161021e565b61074781610ab9565b600061085d600583610220565b64746573743360d81b815260050192915050565b600061087e600283610a93565b61413160f01b815260200192915050565b600061089c600583610220565b643a32b9ba1960d91b815260050192915050565b60006108bd600483610220565b6315d95b9d60e21b815260040192915050565b60006108dd600583610220565b64746573743160d81b815260050192915050565b60006108fe600583610220565b6457726f6e6760d81b815260050192915050565b600061091f600983610220565b68536f6d657468696e6760b81b815260090192915050565b61074781610acb565b600061094b826108d0565b91506109568261088f565b915061035182610850565b600061096c82610912565b9150610977826108b0565b9150610351826108f1565b60208101610351828461073e565b60208082528101610308818461074d565b6020808252810161030881846107a6565b6020810161035182846107f4565b6020810161035182846107fd565b602080825281016103088184610806565b60208101610351828461083e565b602081016103518284610847565b6020808252810161035181610871565b602081016103518284610937565b60405181810167ffffffffffffffff81118282101715610a3857600080fd5b604052919050565b600067ffffffffffffffff821115610a5757600080fd5b5060209081020190565b600067ffffffffffffffff821115610a7857600080fd5b506020601f91909101601f19160190565b60200190565b5190565b90815260200190565b600061035182610abf565b151590565b6001600160f81b03191690565b60000b90565b6001600160a01b031690565b60ff1690565b82818337506000910152565b60005b83811015610af8578181015183820152602001610ae0565b83811115610b07576000848401525b50505050565b601f01601f191690565b610b2081610a9c565b8114610b2b57600080fd5b50565b610b2081610aa7565b610b2081610aac565b610b208161021e565b610b2081610ab9565b610b2081610acb56fea365627a7a72315820210656fe362666693880af0fba22d5ee0c2b5eaabef4daeec17b00e7137dea2c6c6578706572696d656e74616cf564736f6c63430005100040";

    public static final String FUNC_ADDRESSTEST = "addressTest";

    public static final String FUNC_BOOLARRAYTEST = "boolArrayTest";

    public static final String FUNC_BOOLTEST = "boolTest";

    public static final String FUNC_BYTETEST = "byteTest";

    public static final String FUNC_BYTESARRAYTEST = "bytesArrayTest";

    public static final String FUNC_GREET = "greet";

    public static final String FUNC_INT8TEST = "int8Test";

    public static final String FUNC_INTARRAYTEST = "intArrayTest";

    public static final String FUNC_INTTEST = "intTest";

    public static final String FUNC_MULTIPLEPARAMSTEST = "multipleParamsTest";

    public static final String FUNC_STRINGARRAYTEST = "stringArrayTest";

    public static final String FUNC_STRINGTEST = "stringTest";

    public static final String FUNC_UINT8TEST = "uint8Test";

    public static final String FUNC_UINTTEST = "uintTest";

    @Deprecated
    protected MethodParamsTester(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MethodParamsTester(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MethodParamsTester(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MethodParamsTester(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> addressTest(String inputValue) {
        final Function function = new Function(FUNC_ADDRESSTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> boolArrayTest(List<Boolean> inputValue) {
        final Function function = new Function(FUNC_BOOLARRAYTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>(
                        org.web3j.abi.datatypes.Bool.class,
                        org.web3j.abi.Utils.typeMap(inputValue, org.web3j.abi.datatypes.Bool.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bool>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Boolean> boolTest(Boolean inputValue) {
        final Function function = new Function(FUNC_BOOLTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> byteTest(byte[] inputValue) {
        final Function function = new Function(FUNC_BYTETEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes1(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes1>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> bytesArrayTest(byte[] inputValue) {
        final Function function = new Function(FUNC_BYTESARRAYTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> greet() {
        final Function function = new Function(FUNC_GREET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> int8Test(BigInteger inputValue) {
        final Function function = new Function(FUNC_INT8TEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int8(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> intArrayTest(List<BigInteger> inputValue) {
        final Function function = new Function(FUNC_INTARRAYTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Int256>(
                        org.web3j.abi.datatypes.generated.Int256.class,
                        org.web3j.abi.Utils.typeMap(inputValue, org.web3j.abi.datatypes.generated.Int256.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Int256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> intTest(BigInteger inputValue) {
        final Function function = new Function(FUNC_INTTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> multipleParamsTest(BigInteger inputValue1, BigInteger inputValue2, String inputValue3) {
        final Function function = new Function(FUNC_MULTIPLEPARAMSTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(inputValue1), 
                new org.web3j.abi.datatypes.generated.Int256(inputValue2), 
                new org.web3j.abi.datatypes.Utf8String(inputValue3)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> stringArrayTest(List<String> inputValue) {
        final Function function = new Function(FUNC_STRINGARRAYTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(inputValue, org.web3j.abi.datatypes.Utf8String.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> stringTest(String inputValue) {
        final Function function = new Function(FUNC_STRINGTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> uint8Test(BigInteger inputValue) {
        final Function function = new Function(FUNC_UINT8TEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> uintTest(BigInteger inputValue) {
        final Function function = new Function(FUNC_UINTTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(inputValue)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static MethodParamsTester load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MethodParamsTester(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MethodParamsTester load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MethodParamsTester(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MethodParamsTester load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MethodParamsTester(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MethodParamsTester load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MethodParamsTester(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MethodParamsTester> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MethodParamsTester.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MethodParamsTester> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MethodParamsTester.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MethodParamsTester> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MethodParamsTester.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MethodParamsTester> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MethodParamsTester.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
