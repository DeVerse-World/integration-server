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
import org.web3j.abi.datatypes.generated.Uint8;
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
public class EtherGaldToken extends Contract {
    private static final String BINARY = "608060405266038d7ea4c6800060095562000023336401000000006200003b810204565b60048054600160a060020a0319163317905562000120565b6200005660038264010000000062001d9d6200008d82021704565b604051600160a060020a038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b600160a060020a0381161515620000a357600080fd5b620000b88282640100000000620000e8810204565b15620000c357600080fd5b600160a060020a0316600090815260209190915260409020805460ff19166001179055565b6000600160a060020a03821615156200010057600080fd5b50600160a060020a03166000908152602091909152604090205460ff1690565b611e7a80620001306000396000f3006080604052600436106102035763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306fdde038114610208578063095ea7b31461029257806318160ddd146102ca5780631c1c641d146102f157806323b872dd1461030957806324600fc31461033357806324d9dcad1461034a57806327de2f8d14610365578063313ce5671461038957806331ecad66146103b457806339509351146103cc5780633a2dc679146103f057806340c10f191461040b57806342966c681461042f5780634b94f50e146104475780634f7310871461045c5780634faf180c146104715780636a61e5fc146104895780636af3bfce146104a157806370a08231146104c5578063715018a6146104e657806379cc6790146104fb5780638da5cb5b1461051f5780639201de551461055057806394e8767d1461056857806395d89b4114610580578063983b2d561461059557806398650275146105b6578063a457c2d7146105cb578063a4821719146105ef578063a4faf09f146105f7578063a9059cbb14610612578063aa271e1a14610636578063bb714a1f14610657578063cd0555311461067b578063d40a557f146106a2578063dd62ed3e146106ba578063e2cee85e146106e1578063e9395679146106fc578063f2a90b4b14610714578063f2fde38b1461072f578063f3cb543814610750575b600080fd5b34801561021457600080fd5b5061021d610768565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561025757818101518382015260200161023f565b50505050905090810190601f1680156102845780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561029e57600080fd5b506102b6600160a060020a036004351660243561079f565b604080519115158252519081900360200190f35b3480156102d657600080fd5b506102df61081d565b60408051918252519081900360200190f35b3480156102fd57600080fd5b506102df600435610823565b34801561031557600080fd5b506102b6600160a060020a0360043581169060243516604435610838565b34801561033f57600080fd5b506103486108d5565b005b34801561035657600080fd5b50610348600435602435610963565b34801561037157600080fd5b506102b6600160a060020a03600435166024356109e8565b34801561039557600080fd5b5061039e610b61565b6040805160ff9092168252519081900360200190f35b3480156103c057600080fd5b50610348600435610b66565b3480156103d857600080fd5b506102b6600160a060020a0360043516602435610bcc565b3480156103fc57600080fd5b50610348600435602435610c7c565b34801561041757600080fd5b506102b6600160a060020a0360043516602435610d01565b34801561043b57600080fd5b50610348600435610d2a565b34801561045357600080fd5b506102df610d37565b34801561046857600080fd5b506102df610d3d565b34801561047d57600080fd5b50610348600435610d4d565b34801561049557600080fd5b50610348600435610e8a565b3480156104ad57600080fd5b506102b6600160a060020a0360043516602435610ea6565b3480156104d157600080fd5b506102df600160a060020a0360043516610ec5565b3480156104f257600080fd5b50610348610ee0565b34801561050757600080fd5b50610348600160a060020a0360043516602435610f4e565b34801561052b57600080fd5b50610534610f5c565b60408051600160a060020a039092168252519081900360200190f35b34801561055c57600080fd5b5061021d600435610f6b565b34801561057457600080fd5b506102df6004356110e1565b34801561058c57600080fd5b5061021d61113f565b3480156105a157600080fd5b50610348600160a060020a0360043516611176565b3480156105c257600080fd5b50610348611193565b3480156105d757600080fd5b506102b6600160a060020a036004351660243561119e565b6103486111e9565b34801561060357600080fd5b50610348600435602435611238565b34801561061e57600080fd5b506102b6600160a060020a03600435166024356112bd565b34801561064257600080fd5b506102b6600160a060020a03600435166112ca565b34801561066357600080fd5b50610348600160a060020a03600435166024356112e3565b34801561068757600080fd5b50610348600160a060020a0360043516602435604435611330565b3480156106ae57600080fd5b506102df600435611521565b3480156106c657600080fd5b506102df600160a060020a0360043581169060243516611536565b3480156106ed57600080fd5b50610348600435602435611561565b34801561070857600080fd5b5061021d6004356117ca565b34801561072057600080fd5b506103486004356024356117dd565b34801561073b57600080fd5b50610348600160a060020a0360043516611862565b34801561075c57600080fd5b50610348600435611882565b60408051808201909152600981527f457468657247616c640000000000000000000000000000000000000000000000602082015281565b6000600160a060020a03831615156107b657600080fd5b336000818152600160209081526040808320600160a060020a03881680855290835292819020869055805186815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a350600192915050565b60025490565b60009081526006602052604090206001015490565b600160a060020a038316600090815260016020908152604080832033845290915281205482111561086857600080fd5b600160a060020a038416600090815260016020908152604080832033845290915290205461089c908363ffffffff6118e816565b600160a060020a03851660009081526001602090815260408083203384529091529020556108cb8484846118ff565b5060019392505050565b600454600090600160a060020a031633146108ef57600080fd5b5060045460405130803192600160a060020a031691903180156108fc02916000818181858888f1935050505015801561092c573d6000803e3d6000fd5b506040805182815290517f430648de173157e069201c943adb2d4e340e7cf5b27b1b09c9cb852f03d63b569181900360200190a150565b61096b611e37565b600454600160a060020a0316331461098257600080fd5b5060408051808201825283815260208082018481526000868152600883528490208351815590516001909101558251858152925191927f5f9c2ea8b2ea07dceb39996762bb28af4cc5ed42e4b4ac84c3432bcb9ae06368929081900390910190a1505050565b60006060836109f6846117ca565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b60208310610a4f5780518252601f199092019160209182019101610a30565b6001836020036101000a0380198251168184511680821785525050505050509050019250505060405160208183030381529060405290506005816040518082805190602001908083835b60208310610ab85780518252601f199092019160209182019101610a99565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220544210801592509050610b5957506005816040518082805190602001908083835b60208310610b235780518252601f199092019160209182019101610b04565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220600101544211159150505b949350505050565b600081565b600454600160a060020a03163314610b7d57600080fd5b600081815260066020908152604080832083815560010192909255815183815291517fa51c5188e1948c771c5869a9d2c919518028dc8e3c947dd22fd3ae13aeda4c4a9281900390910190a150565b6000600160a060020a0383161515610be357600080fd5b336000908152600160209081526040808320600160a060020a0387168452909152902054610c17908363ffffffff6119f116565b336000818152600160209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b610c84611e37565b600454600160a060020a03163314610c9b57600080fd5b5060408051808201825283815260208082018481526000868152600883528490208351815590516001909101558251858152925191927f324840da1b07686a48ba5e392904b4ce809de98ec4a720311da7286d913cdf79929081900390910190a1505050565b6000610d0c336112ca565b1515610d1757600080fd5b610d218383611a0a565b50600192915050565b610d343382611ab4565b50565b60095490565b6000610d4833610ec5565b905090565b6000818152600860205260409020541515610d6757600080fd5b600081815260086020526040902060010154610d8233610ec5565b1015610dd8576040805160e560020a62461bcd02815260206004820152601960248201527f4572726f723a20696e73756666696369656e742066756e647300000000000000604482015290519081900360640190fd5b610de23382610ea6565b15610e5d576040805160e560020a62461bcd02815260206004820152602160248201527f4572726f723a207072656d69756d206974656d20616c7265616479206f776e6560448201527f6400000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b600081815260086020526040902060010154610e7890610d2a565b33600090815260076020526040902055565b600454600160a060020a03163314610ea157600080fd5b600955565b600160a060020a03919091166000908152600760205260409020541490565b600160a060020a031660009081526020819052604090205490565b600454600160a060020a03163314610ef757600080fd5b600454604051600160a060020a03909116907ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482090600090a26004805473ffffffffffffffffffffffffffffffffffffffff19169055565b610f588282611b82565b5050565b600454600160a060020a031681565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b602083101561102f576008830260020a870291507fff0000000000000000000000000000000000000000000000000000000000000082161561102457818585815181101515610fed57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001909301925b600190920191610fa2565b836040519080825280601f01601f19166020018201604052801561105d578160200160208202803883390190505b509050600092505b838310156110d757848381518110151561107b57fe5b90602001015160f860020a900460f860020a02818481518110151561109c57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600190920191611065565b9695505050505050565b600081151561111157507f300000000000000000000000000000000000000000000000000000000000000061113a565b600082111561113a5761010081049050600a820660300160f860020a0217600a82049150611111565b919050565b60408051808201909152600281527f4547000000000000000000000000000000000000000000000000000000000000602082015281565b61117f336112ca565b151561118a57600080fd5b610d3481611c14565b61119c33611c5c565b565b6000600160a060020a03831615156111b557600080fd5b336000908152600160209081526040808320600160a060020a0387168452909152902054610c17908363ffffffff6118e816565b600061120060095434611ca490919063ffffffff16565b1561120a57600080fd5b60095461121e90349063ffffffff611cc516565b9050600181101561122e57600080fd5b610d343382611a0a565b611240611e37565b600454600160a060020a0316331461125757600080fd5b5060408051808201825283815260208082018481526000868152600683528490208351815590516001909101558251858152925191927f2bf5da1e90f7b3234642edd1283811b71e4130202f7f9024b5b260ae536af5df929081900390910190a1505050565b6000610d213384846118ff565b60006112dd60038363ffffffff611ce816565b92915050565b600454600160a060020a031633146112fa57600080fd5b600081815260086020526040902054151561131457600080fd5b600160a060020a03909116600090815260076020526040902055565b611338611e37565b600454606090600160a060020a0316331461135257600080fd5b600083815260066020526040902054151561136c57600080fd5b61137685846109e8565b156113f1576040805160e560020a62461bcd02815260206004820152602b60248201527f4572726f723a207072656d69756d20737562736372697074696f6e206973207360448201527f74696c6c20616374697665000000000000000000000000000000000000000000606482015290519081900360840190fd5b6040805180820190915242808252620151808602016020820152915084611417846117ca565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b602083106114705780518252601f199092019160209182019101611451565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040529050816005826040518082805190602001908083835b602083106114da5780518252601f1990920191602091820191016114bb565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084518155939092015160019093019290925550505050505050565b60009081526008602052604090206001015490565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b611569611e37565b600082815260066020526040902054606090151561158657600080fd5b60008381526006602052604090206001015484026115a333610ec5565b10156115f9576040805160e560020a62461bcd02815260206004820152601960248201527f4572726f723a20696e73756666696369656e742066756e647300000000000000604482015290519081900360640190fd5b61160333846109e8565b1561167e576040805160e560020a62461bcd02815260206004820152602b60248201527f4572726f723a207072656d69756d20737562736372697074696f6e206973207360448201527f74696c6c20616374697665000000000000000000000000000000000000000000606482015290519081900360840190fd5b60008381526006602052604090206001015461169b908502610d2a565b60408051808201909152428082526201518086020160208201529150336116c1846117ca565b6040516020018083600160a060020a0316600160a060020a03166c0100000000000000000000000002815260140182805190602001908083835b6020831061171a5780518252601f1990920191602091820191016116fb565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040529050816005826040518082805190602001908083835b602083106117845780518252601f199092019160209182019101611765565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845181559390920151600190930192909255505050505050565b60606112dd6117d8836110e1565b610f6b565b6117e5611e37565b600454600160a060020a031633146117fc57600080fd5b5060408051808201825283815260208082018481526000868152600683528490208351815590516001909101558251858152925191927f99e5fc2422da5e949a914149894c1b8cb972a4edec220e66c58a5968a668dc0d929081900390910190a1505050565b600454600160a060020a0316331461187957600080fd5b610d3481611d1f565b600454600160a060020a0316331461189957600080fd5b600081815260086020908152604080832083815560010192909255815183815291517f0e37a5803a75db34b651d4e8b54e6454320dc026c797d41dc7e136b0033582bc9281900390910190a150565b600080838311156118f857600080fd5b5050900390565b600160a060020a03831660009081526020819052604090205481111561192457600080fd5b600160a060020a038216151561193957600080fd5b600160a060020a038316600090815260208190526040902054611962908263ffffffff6118e816565b600160a060020a038085166000908152602081905260408082209390935590841681522054611997908263ffffffff6119f116565b600160a060020a038084166000818152602081815260409182902094909455805185815290519193928716927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef92918290030190a3505050565b600082820183811015611a0357600080fd5b9392505050565b600160a060020a0382161515611a1f57600080fd5b600254611a32908263ffffffff6119f116565b600255600160a060020a038216600090815260208190526040902054611a5e908263ffffffff6119f116565b600160a060020a0383166000818152602081815260408083209490945583518581529351929391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a35050565b600160a060020a0382161515611ac957600080fd5b600160a060020a038216600090815260208190526040902054811115611aee57600080fd5b600254611b01908263ffffffff6118e816565b600255600160a060020a038216600090815260208190526040902054611b2d908263ffffffff6118e816565b600160a060020a038316600081815260208181526040808320949094558351858152935191937fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929081900390910190a35050565b600160a060020a0382166000908152600160209081526040808320338452909152902054811115611bb257600080fd5b600160a060020a0382166000908152600160209081526040808320338452909152902054611be6908263ffffffff6118e816565b600160a060020a0383166000908152600160209081526040808320338452909152902055610f588282611ab4565b611c2560038263ffffffff611d9d16565b604051600160a060020a038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b611c6d60038263ffffffff611deb16565b604051600160a060020a038216907fe94479a9f7e1952cc78f2d6baab678adc1b772d936c6583def489e524cb6669290600090a250565b6000811515611cb257600080fd5b8183811515611cbd57fe5b069392505050565b600080808311611cd457600080fd5b8284811515611cdf57fe5b04949350505050565b6000600160a060020a0382161515611cff57600080fd5b50600160a060020a03166000908152602091909152604090205460ff1690565b600160a060020a0381161515611d3457600080fd5b600454604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36004805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600160a060020a0381161515611db257600080fd5b611dbc8282611ce8565b15611dc657600080fd5b600160a060020a0316600090815260209190915260409020805460ff19166001179055565b600160a060020a0381161515611e0057600080fd5b611e0a8282611ce8565b1515611e1557600080fd5b600160a060020a0316600090815260209190915260409020805460ff19169055565b6040805180820190915260008082526020820152905600a165627a7a72305820e580dd42e80fa20b3525774c7adca84c12a3dc422fedf23e9b81ac5368d8a1960029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_GETPREMIUMSUBSCRIPTIONPRICEPERDAY = "getPremiumSubscriptionPricePerDay";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_WITHDRAWFUNDS = "withdrawFunds";

    public static final String FUNC_EDITPREMIUMITEM = "editPremiumItem";

    public static final String FUNC_CHECKPREMIUMSUBSCRIPTION = "checkPremiumSubscription";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DELETEPREMIUMSUBSCRIPTIONTYPE = "deletePremiumSubscriptionType";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_ADDPREMIUMITEM = "addPremiumItem";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_GETTOKENPRICE = "getTokenPrice";

    public static final String FUNC_CHECKTOKENBALANCE = "checkTokenBalance";

    public static final String FUNC_BUYPREMIUMITEM = "buyPremiumItem";

    public static final String FUNC_SETTOKENPRICE = "setTokenPrice";

    public static final String FUNC_CHECKPREMIUMITEM = "checkPremiumItem";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_BURNFROM = "burnFrom";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_UINTTOBYTES = "uintToBytes";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_ADDMINTER = "addMinter";

    public static final String FUNC_RENOUNCEMINTER = "renounceMinter";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_BUYTOKEN = "buyToken";

    public static final String FUNC_ADDPREMIUMSUBSCRIPTIONTYPE = "addPremiumSubscriptionType";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_ISMINTER = "isMinter";

    public static final String FUNC_GRANTPREMIUMITEM = "grantPremiumItem";

    public static final String FUNC_GRANTPREMIUMSUBSCRIPTION = "grantPremiumSubscription";

    public static final String FUNC_GETPREMIUMITEMPRICE = "getPremiumItemPrice";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_BUYPREMIUMSUBSCRIPTION = "buyPremiumSubscription";

    public static final String FUNC_UINTTOSTRING = "uintToString";

    public static final String FUNC_EDITPREMIUMSUBSCRIPTIONTYPE = "editPremiumSubscriptionType";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DELETEPREMIUMITEM = "deletePremiumItem";

    public static final Event WITHDRAWN_EVENT = new Event("Withdrawn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event ADDPREMIUMITEMEVENT_EVENT = new Event("AddPremiumItemEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event EDITPREMIUMITEMEVENT_EVENT = new Event("EditPremiumItemEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event DELETEPREMIUMITEMEVENT_EVENT = new Event("DeletePremiumItemEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

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

    public static final Event MINTERADDED_EVENT = new Event("MinterAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event MINTERREMOVED_EVENT = new Event("MinterRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected EtherGaldToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EtherGaldToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EtherGaldToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EtherGaldToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<TransactionReceipt> withdrawFunds() {
        final Function function = new Function(
                FUNC_WITHDRAWFUNDS, 
                Arrays.<Type>asList(), 
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

    public RemoteCall<Boolean> checkPremiumSubscription(String _user, BigInteger _premiumSubscriptionTypeId) {
        final Function function = new Function(FUNC_CHECKPREMIUMSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_premiumSubscriptionTypeId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<TransactionReceipt> addPremiumItem(BigInteger _itemId, BigInteger _itemPrice) {
        final Function function = new Function(
                FUNC_ADDPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mint(String to, BigInteger value) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
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

    public RemoteCall<BigInteger> getTokenPrice() {
        final Function function = new Function(FUNC_GETTOKENPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> checkTokenBalance() {
        final Function function = new Function(FUNC_CHECKTOKENBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> buyPremiumItem(BigInteger _itemId) {
        final Function function = new Function(
                FUNC_BUYPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setTokenPrice(BigInteger _price) {
        final Function function = new Function(
                FUNC_SETTOKENPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)), 
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

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addMinter(String account) {
        final Function function = new Function(
                FUNC_ADDMINTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> renounceMinter() {
        final Function function = new Function(
                FUNC_RENOUNCEMINTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> buyToken(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYTOKEN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public RemoteCall<Boolean> isMinter(String account) {
        final Function function = new Function(FUNC_ISMINTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> grantPremiumItem(String _user, BigInteger _itemId) {
        final Function function = new Function(
                FUNC_GRANTPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
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

    public RemoteCall<TransactionReceipt> deletePremiumItem(BigInteger _itemId) {
        final Function function = new Function(
                FUNC_DELETEPREMIUMITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<WithdrawnEventResponse> getWithdrawnEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWN_EVENT, transactionReceipt);
        ArrayList<WithdrawnEventResponse> responses = new ArrayList<WithdrawnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawnEventResponse typedResponse = new WithdrawnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.weiAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawnEventResponse> withdrawnEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawnEventResponse>() {
            @Override
            public WithdrawnEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAWN_EVENT, log);
                WithdrawnEventResponse typedResponse = new WithdrawnEventResponse();
                typedResponse.log = log;
                typedResponse.weiAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WithdrawnEventResponse> withdrawnEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWN_EVENT));
        return withdrawnEventObservable(filter);
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

    public List<MinterAddedEventResponse> getMinterAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTERADDED_EVENT, transactionReceipt);
        ArrayList<MinterAddedEventResponse> responses = new ArrayList<MinterAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MinterAddedEventResponse typedResponse = new MinterAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MinterAddedEventResponse> minterAddedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MinterAddedEventResponse>() {
            @Override
            public MinterAddedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTERADDED_EVENT, log);
                MinterAddedEventResponse typedResponse = new MinterAddedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MinterAddedEventResponse> minterAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTERADDED_EVENT));
        return minterAddedEventObservable(filter);
    }

    public List<MinterRemovedEventResponse> getMinterRemovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTERREMOVED_EVENT, transactionReceipt);
        ArrayList<MinterRemovedEventResponse> responses = new ArrayList<MinterRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MinterRemovedEventResponse typedResponse = new MinterRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MinterRemovedEventResponse> minterRemovedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MinterRemovedEventResponse>() {
            @Override
            public MinterRemovedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTERREMOVED_EVENT, log);
                MinterRemovedEventResponse typedResponse = new MinterRemovedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MinterRemovedEventResponse> minterRemovedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTERREMOVED_EVENT));
        return minterRemovedEventObservable(filter);
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

    public static RemoteCall<EtherGaldToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EtherGaldToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EtherGaldToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EtherGaldToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EtherGaldToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EtherGaldToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EtherGaldToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EtherGaldToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static EtherGaldToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EtherGaldToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EtherGaldToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EtherGaldToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EtherGaldToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EtherGaldToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EtherGaldToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EtherGaldToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class WithdrawnEventResponse {
        public Log log;

        public BigInteger weiAmount;
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

    public static class MinterAddedEventResponse {
        public Log log;

        public String account;
    }

    public static class MinterRemovedEventResponse {
        public Log log;

        public String account;
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
