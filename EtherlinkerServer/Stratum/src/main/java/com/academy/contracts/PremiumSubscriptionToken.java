package com.academy.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
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
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class PremiumSubscriptionToken extends Contract {
    public static final String BINARY = "608060405260006100176001600160e01b0361006a16565b600380546001600160a01b0319166001600160a01b038316908117909155604051919250906000907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a35061006e565b3390565b611ba18061007d6000396000f3fe608060405234801561001057600080fd5b50600436106101c45760003560e01c80638da5cb5b116100f9578063acabdf7511610097578063e2cee85e11610071578063e2cee85e14610399578063e9395679146103ac578063f2a90b4b146103bf578063f2fde38b146103d2576101c4565b8063acabdf7514610360578063cd05553114610373578063dd62ed3e14610386576101c4565b806394e8767d116100d357806394e8767d14610314578063a457c2d714610327578063a4faf09f1461033a578063a9059cbb1461034d576101c4565b80638da5cb5b146102e45780638f32d59b146102ec5780639201de55146102f4576101c4565b8063395093511161016657806366951e391161014057806366951e39146102a357806370a08231146102b6578063715018a6146102c957806379cc6790146102d1576101c4565b8063395093511461026857806342966c681461027b57806348b681401461028e576101c4565b80631c1c641d116101a25780631c1c641d1461021c57806323b872dd1461022f57806327de2f8d1461024257806331ecad6614610255576101c4565b8063095ea7b3146101c95780631420ee22146101f257806318160ddd14610207575b600080fd5b6101dc6101d7366004611485565b6103e5565b6040516101e9919061193e565b60405180910390f35b6102056102003660046114e7565b610403565b005b61020f6104c3565b6040516101e9919061194c565b61020f61022a366004611599565b6104c9565b6101dc61023d366004611438565b6104de565b6101dc610250366004611485565b61056b565b610205610263366004611599565b6105f3565b6101dc610276366004611485565b610669565b610205610289366004611599565b6106bd565b6102966106d1565b6040516101e99190611930565b6102056102b1366004611529565b610707565b61020f6102c43660046113e0565b610816565b610205610831565b6102056102df366004611485565b61089f565b6102966108ad565b6101dc6108bc565b610307610302366004611599565b6108e2565b6040516101e9919061195a565b61020f610322366004611599565b6109e7565b6101dc610335366004611485565b610a31565b6102056103483660046115b7565b610a9f565b6101dc61035b366004611485565b610b36565b61020561036e366004611529565b610b4a565b6102056103813660046114b5565b610c52565b61020f6103943660046113fe565b610d3b565b6102056103a73660046115b7565b610d66565b6103076103ba366004611599565b610e82565b6102056103cd3660046115b7565b610e90565b6102056103e03660046113e0565b610f1a565b60006103f96103f2610f47565b8484610f4b565b5060015b92915050565b61040b6108bc565b6104305760405162461bcd60e51b8152600401610427906119bb565b60405180910390fd5b60005b818110156104be576005600084848481811061044b57fe5b602090810292909201358352508101919091526040016000908120818155600101557fa51c5188e1948c771c5869a9d2c919518028dc8e3c947dd22fd3ae13aeda4c4a83838381811061049a57fe5b905060200201356040516104ae919061194c565b60405180910390a1600101610433565b505050565b60025490565b60009081526005602052604090206001015490565b60006104eb848484610fff565b610561846104f7610f47565b61055c85604051806060016040528060288152602001611aee602891396001600160a01b038a16600090815260016020526040812090610535610f47565b6001600160a01b03168152602081019190915260400160002054919063ffffffff61111516565b610f4b565b5060019392505050565b600060608361057984610e82565b60405160200161058a929190611908565b60405160208183030381529060405290506004816040516105ab9190611924565b9081526040519081900360200190205442108015906105eb57506004816040516105d59190611924565b9081526020016040518091039020600101544211155b949350505050565b6105fb6108bc565b6106175760405162461bcd60e51b8152600401610427906119bb565b60008181526005602052604080822082815560010191909155517fa51c5188e1948c771c5869a9d2c919518028dc8e3c947dd22fd3ae13aeda4c4a9061065e90839061194c565b60405180910390a150565b60006103f9610676610f47565b8461055c8560016000610687610f47565b6001600160a01b03908116825260208083019390935260409182016000908120918c16815292529020549063ffffffff61114116565b6106ce6106c8610f47565b8261116d565b50565b60006106db6108bc565b6106f75760405162461bcd60e51b8152600401610427906119bb565b506003546001600160a01b031690565b61070f6108bc565b61072b5760405162461bcd60e51b8152600401610427906119bb565b82811461073757600080fd5b60005b8381101561080f5761074a611367565b604051806040016040528087878581811061076157fe5b90506020020135815260200185858581811061077957fe5b905060200201358152509050806005600088888681811061079657fe5b6020908102929092013583525081810192909252604001600020825181559101516001909101557f2bf5da1e90f7b3234642edd1283811b71e4130202f7f9024b5b260ae536af5df8686848181106107ea57fe5b905060200201356040516107fe919061194c565b60405180910390a15060010161073a565b5050505050565b6001600160a01b031660009081526020819052604090205490565b6108396108bc565b6108555760405162461bcd60e51b8152600401610427906119bb565b6003546040516000916001600160a01b0316907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908390a3600380546001600160a01b0319169055565b6108a9828261124f565b5050565b6003546001600160a01b031690565b6003546000906001600160a01b03166108d3610f47565b6001600160a01b031614905090565b6040805160208082528183019092526060918291906020820181803883390190505090506000805b6020811015610960576008810260020a85026001600160f81b0319811615610957578084848151811061093957fe5b60200101906001600160f81b031916908160001a9053506001909201915b5060010161090a565b506060816040519080825280601f01601f19166020018201604052801561098e576020820181803883390190505b50905060005b828110156109de578381815181106109a857fe5b602001015160f81c60f81b8282815181106109bf57fe5b60200101906001600160f81b031916908160001a905350600101610994565b50949350505050565b6000816109f95750600360fc1b610a2c565b8115610a2c5761010081049050600a8206603001600160f81b0260001b81179050600a8281610a2457fe5b0491506109f9565b919050565b60006103f9610a3e610f47565b8461055c85604051806060016040528060258152602001611b3a6025913960016000610a68610f47565b6001600160a01b03908116825260208083019390935260409182016000908120918d1681529252902054919063ffffffff61111516565b610aa76108bc565b610ac35760405162461bcd60e51b8152600401610427906119bb565b610acb611367565b506040805180820182528381526020808201848152600086815260059092529083902082518155905160019091015590517f2bf5da1e90f7b3234642edd1283811b71e4130202f7f9024b5b260ae536af5df90610b2990859061194c565b60405180910390a1505050565b60006103f9610b43610f47565b8484610fff565b610b526108bc565b610b6e5760405162461bcd60e51b8152600401610427906119bb565b828114610b7a57600080fd5b60005b8381101561080f57610b8d611367565b6040518060400160405280878785818110610ba457fe5b905060200201358152602001858585818110610bbc57fe5b9050602002013581525090508060056000888886818110610bd957fe5b6020908102929092013583525081810192909252604001600020825181559101516001909101557f99e5fc2422da5e949a914149894c1b8cb972a4edec220e66c58a5968a668dc0d868684818110610c2d57fe5b90506020020135604051610c41919061194c565b60405180910390a150600101610b7d565b610c5a6108bc565b610c765760405162461bcd60e51b8152600401610427906119bb565b600081815260056020526040902054610c8e57600080fd5b610c98838261056b565b15610cb55760405162461bcd60e51b8152600401610427906119ab565b610cbd611367565b506040805180820190915242808252620151808402016020820152606084610ce484610e82565b604051602001610cf5929190611908565b604051602081830303815290604052905081600482604051610d179190611924565b90815260405160209181900382019020825181559101516001909101555050505050565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205490565b600081815260056020526040902054610d7e57600080fd5b6000818152600560205260409020600101548202610d9b33610816565b1015610db95760405162461bcd60e51b8152600401610427906119eb565b610dc3338261056b565b15610de05760405162461bcd60e51b8152600401610427906119ab565b600081815260056020526040902060010154610dfd9083026106bd565b610e05611367565b506040805180820190915242808252620151808402016020820152606033610e2c84610e82565b604051602001610e3d929190611908565b604051602081830303815290604052905081600482604051610e5f9190611924565b908152604051602091819003820190208251815591015160019091015550505050565b60606103fd610302836109e7565b610e986108bc565b610eb45760405162461bcd60e51b8152600401610427906119bb565b610ebc611367565b506040805180820182528381526020808201848152600086815260059092529083902082518155905160019091015590517f99e5fc2422da5e949a914149894c1b8cb972a4edec220e66c58a5968a668dc0d90610b2990859061194c565b610f226108bc565b610f3e5760405162461bcd60e51b8152600401610427906119bb565b6106ce816112a3565b3390565b6001600160a01b038316610f715760405162461bcd60e51b8152600401610427906119fb565b6001600160a01b038216610f975760405162461bcd60e51b81526004016104279061198b565b6001600160a01b0380841660008181526001602090815260408083209487168084529490915290819020849055517f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92590610ff290859061194c565b60405180910390a3505050565b6001600160a01b0383166110255760405162461bcd60e51b8152600401610427906119db565b6001600160a01b03821661104b5760405162461bcd60e51b81526004016104279061196b565b61108e81604051806060016040528060268152602001611ac8602691396001600160a01b038616600090815260208190526040902054919063ffffffff61111516565b6001600160a01b0380851660009081526020819052604080822093909355908416815220546110c3908263ffffffff61114116565b6001600160a01b0380841660008181526020819052604090819020939093559151908516907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef90610ff290859061194c565b600081848411156111395760405162461bcd60e51b8152600401610427919061195a565b505050900390565b6000828201838110156111665760405162461bcd60e51b81526004016104279061199b565b9392505050565b6001600160a01b0382166111935760405162461bcd60e51b8152600401610427906119cb565b6111d681604051806060016040528060228152602001611aa6602291396001600160a01b038516600090815260208190526040902054919063ffffffff61111516565b6001600160a01b038316600090815260208190526040902055600254611202908263ffffffff61132516565b6002556040516000906001600160a01b038416907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9061124390859061194c565b60405180910390a35050565b611259828261116d565b6108a982611265610f47565b61055c84604051806060016040528060248152602001611b16602491396001600160a01b038816600090815260016020526040812090610535610f47565b6001600160a01b0381166112c95760405162461bcd60e51b81526004016104279061197b565b6003546040516001600160a01b038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a3600380546001600160a01b0319166001600160a01b0392909216919091179055565b600061116683836040518060400160405280601e81526020017f536166654d6174683a207375627472616374696f6e206f766572666c6f770000815250611115565b604051806040016040528060008152602001600081525090565b80356103fd81611a88565b60008083601f84011261139e57600080fd5b50813567ffffffffffffffff8111156113b657600080fd5b6020830191508360208202830111156113ce57600080fd5b9250929050565b80356103fd81611a9c565b6000602082840312156113f257600080fd5b60006105eb8484611381565b6000806040838503121561141157600080fd5b600061141d8585611381565b925050602061142e85828601611381565b9150509250929050565b60008060006060848603121561144d57600080fd5b60006114598686611381565b935050602061146a86828701611381565b925050604061147b868287016113d5565b9150509250925092565b6000806040838503121561149857600080fd5b60006114a48585611381565b925050602061142e858286016113d5565b6000806000606084860312156114ca57600080fd5b60006114d68686611381565b935050602061146a868287016113d5565b600080602083850312156114fa57600080fd5b823567ffffffffffffffff81111561151157600080fd5b61151d8582860161138c565b92509250509250929050565b6000806000806040858703121561153f57600080fd5b843567ffffffffffffffff81111561155657600080fd5b6115628782880161138c565b9450945050602085013567ffffffffffffffff81111561158157600080fd5b61158d8782880161138c565b95989497509550505050565b6000602082840312156115ab57600080fd5b60006105eb84846113d5565b600080604083850312156115ca57600080fd5b60006114a485856113d5565b6115df81611a18565b82525050565b6115df6115f182611a18565b611a67565b6115df81611a23565b6115df81611a28565b600061161382611a0b565b61161d8185611a0f565b935061162d818560208601611a37565b61163681611a78565b9093019392505050565b600061164b82611a0b565b6116558185610a2c565b9350611665818560208601611a37565b9290920192915050565b600061167c602383611a0f565b7f45524332303a207472616e7366657220746f20746865207a65726f206164647281526265737360e81b602082015260400192915050565b60006116c1602683611a0f565b7f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206181526564647265737360d01b602082015260400192915050565b6000611709602283611a0f565b7f45524332303a20617070726f766520746f20746865207a65726f206164647265815261737360f01b602082015260400192915050565b600061174d601b83611a0f565b7f536166654d6174683a206164646974696f6e206f766572666c6f770000000000815260200192915050565b6000611786602b83611a0f565b7f4572726f723a207072656d69756d20737562736372697074696f6e206973207381526a74696c6c2061637469766560a81b602082015260400192915050565b60006117d3602083611a0f565b7f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572815260200192915050565b600061180c602183611a0f565b7f45524332303a206275726e2066726f6d20746865207a65726f206164647265738152607360f81b602082015260400192915050565b600061184f602583611a0f565b7f45524332303a207472616e736665722066726f6d20746865207a65726f206164815264647265737360d81b602082015260400192915050565b6000611896601983611a0f565b7f4572726f723a20696e73756666696369656e742066756e647300000000000000815260200192915050565b60006118cf602483611a0f565b7f45524332303a20617070726f76652066726f6d20746865207a65726f206164648152637265737360e01b602082015260400192915050565b600061191482856115e5565b6014820191506105eb8284611640565b60006111668284611640565b602081016103fd82846115d6565b602081016103fd82846115f6565b602081016103fd82846115ff565b602080825281016111668184611608565b602080825281016103fd8161166f565b602080825281016103fd816116b4565b602080825281016103fd816116fc565b602080825281016103fd81611740565b602080825281016103fd81611779565b602080825281016103fd816117c6565b602080825281016103fd816117ff565b602080825281016103fd81611842565b602080825281016103fd81611889565b602080825281016103fd816118c2565b5190565b90815260200190565b60006103fd82611a2b565b151590565b90565b6001600160a01b031690565b60005b83811015611a52578181015183820152602001611a3a565b83811115611a61576000848401525b50505050565b60006103fd8260006103fd82611a82565b601f01601f191690565b60601b90565b611a9181611a18565b81146106ce57600080fd5b611a9181611a2856fe45524332303a206275726e20616d6f756e7420657863656564732062616c616e636545524332303a207472616e7366657220616d6f756e7420657863656564732062616c616e636545524332303a207472616e7366657220616d6f756e74206578636565647320616c6c6f77616e636545524332303a206275726e20616d6f756e74206578636565647320616c6c6f77616e636545524332303a2064656372656173656420616c6c6f77616e63652062656c6f77207a65726fa365627a7a723158206f0fbae2830c7ea95b4f31c2f05c1e99efb75d25622a00f3e251be683980beef6c6578706572696d656e74616cf564736f6c63430005100040";

    public static final String FUNC_ADDPREMIUMSUBSCRIPTIONTYPE = "addPremiumSubscriptionType";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BATCHADDPREMIUMSUBSCRIPTIONTYPES = "batchAddPremiumSubscriptionTypes";

    public static final String FUNC_BATCHDELETEPREMIUMSUBSCRIPTIONTYPES = "batchDeletePremiumSubscriptionTypes";

    public static final String FUNC_BATCHEDITPREMIUMSUBSCRIPTIONTYPES = "batchEditPremiumSubscriptionTypes";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_BUYPREMIUMSUBSCRIPTION = "buyPremiumSubscription";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_CHECKPREMIUMSUBSCRIPTION = "checkPremiumSubscription";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_DELETEPREMIUMSUBSCRIPTIONTYPE = "deletePremiumSubscriptionType";

    public static final String FUNC_EDITPREMIUMSUBSCRIPTIONTYPE = "editPremiumSubscriptionType";

    public static final String FUNC_GETPREMIUMSUBSCRIPTIONPRICEPERDAY = "getPremiumSubscriptionPricePerDay";

    public static final String FUNC_GRANTPREMIUMSUBSCRIPTION = "grantPremiumSubscription";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNERPAYABLE = "ownerPayable";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UINTTOBYTES = "uintToBytes";

    public static final String FUNC_UINTTOSTRING = "uintToString";

    public static final Event ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT = new Event("AddPremiumSubscriptionTypeEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT = new Event("DeletePremiumSubscriptionTypeEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT = new Event("EditPremiumSubscriptionTypeEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
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

    public Flowable<AddPremiumSubscriptionTypeEventEventResponse> addPremiumSubscriptionTypeEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddPremiumSubscriptionTypeEventEventResponse>() {
            @Override
            public AddPremiumSubscriptionTypeEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, log);
                AddPremiumSubscriptionTypeEventEventResponse typedResponse = new AddPremiumSubscriptionTypeEventEventResponse();
                typedResponse.log = log;
                typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddPremiumSubscriptionTypeEventEventResponse> addPremiumSubscriptionTypeEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT));
        return addPremiumSubscriptionTypeEventEventFlowable(filter);
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

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
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

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
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

    public Flowable<DeletePremiumSubscriptionTypeEventEventResponse> deletePremiumSubscriptionTypeEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DeletePremiumSubscriptionTypeEventEventResponse>() {
            @Override
            public DeletePremiumSubscriptionTypeEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, log);
                DeletePremiumSubscriptionTypeEventEventResponse typedResponse = new DeletePremiumSubscriptionTypeEventEventResponse();
                typedResponse.log = log;
                typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DeletePremiumSubscriptionTypeEventEventResponse> deletePremiumSubscriptionTypeEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETEPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT));
        return deletePremiumSubscriptionTypeEventEventFlowable(filter);
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

    public Flowable<EditPremiumSubscriptionTypeEventEventResponse> editPremiumSubscriptionTypeEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EditPremiumSubscriptionTypeEventEventResponse>() {
            @Override
            public EditPremiumSubscriptionTypeEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT, log);
                EditPremiumSubscriptionTypeEventEventResponse typedResponse = new EditPremiumSubscriptionTypeEventEventResponse();
                typedResponse.log = log;
                typedResponse._premiumSubscriptionTypeId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EditPremiumSubscriptionTypeEventEventResponse> editPremiumSubscriptionTypeEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EDITPREMIUMSUBSCRIPTIONTYPEEVENT_EVENT));
        return editPremiumSubscriptionTypeEventEventFlowable(filter);
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

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
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

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
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

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addPremiumSubscriptionType(BigInteger _premiumSubscriptionTypeId, BigInteger _premiumSubscriptionPricePerDay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDPREMIUMSUBSCRIPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionPricePerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> batchAddPremiumSubscriptionTypes(List<BigInteger> _premiumSubscriptionTypeIds, List<BigInteger> _premiumSubscriptionPricesPerDay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BATCHADDPREMIUMSUBSCRIPTIONTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionTypeIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionPricesPerDay, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> batchDeletePremiumSubscriptionTypes(List<BigInteger> _premiumSubscriptionTypeIds) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BATCHDELETEPREMIUMSUBSCRIPTIONTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionTypeIds, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> batchEditPremiumSubscriptionTypes(List<BigInteger> _premiumSubscriptionTypeIds, List<BigInteger> _premiumSubscriptionPricesPerDay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BATCHEDITPREMIUMSUBSCRIPTIONTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionTypeIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_premiumSubscriptionPricesPerDay, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> burnFrom(String account, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURNFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> buyPremiumSubscription(BigInteger _days, BigInteger _premiumSubscriptionTypeId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BUYPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_days), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> bytes32ToString(byte[] x) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BYTES32TOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(x)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> checkPremiumSubscription(String _user, BigInteger _premiumSubscriptionTypeId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHECKPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deletePremiumSubscriptionType(BigInteger _premiumSubscriptionTypeId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELETEPREMIUMSUBSCRIPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> editPremiumSubscriptionType(BigInteger _premiumSubscriptionTypeId, BigInteger _premiumSubscriptionPricePerDay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EDITPREMIUMSUBSCRIPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionPricePerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getPremiumSubscriptionPricePerDay(BigInteger _premiumSubscriptionTypeId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPREMIUMSUBSCRIPTIONPRICEPERDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> grantPremiumSubscription(String _user, BigInteger _days, BigInteger _premiumSubscriptionTypeId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GRANTPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint256(_days), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isOwner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ownerPayable() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNERPAYABLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String sender, String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, sender), 
                new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> uintToBytes(BigInteger v) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_UINTTOBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(v)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> uintToString(BigInteger v) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_UINTTOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(v)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public static class AddPremiumSubscriptionTypeEventEventResponse extends BaseEventResponse {
        public BigInteger _premiumSubscriptionTypeId;
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class DeletePremiumSubscriptionTypeEventEventResponse extends BaseEventResponse {
        public BigInteger _premiumSubscriptionTypeId;
    }

    public static class EditPremiumSubscriptionTypeEventEventResponse extends BaseEventResponse {
        public BigInteger _premiumSubscriptionTypeId;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
