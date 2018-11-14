package com.academy.stratum.controller;

import com.academy.stratum.dto.EtherlinkerRequestData;
import com.academy.stratum.service.EthereumService;
import com.academy.utils.Ajax;
import com.academy.utils.RestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Processing all JSON-requests from compatible apps (like UE4) and executing operations on Ethereum blockchain
 * @see EthereumService
 *
 * @author Ruslan Nazirov
 */
@Controller
public class EtherlinkerController {

    @Autowired
    private EthereumService ethereumService;

    private static final Logger LOG = LoggerFactory.getLogger(EtherlinkerController.class);

    /**
     * Getting balance of specified wallet
     * @param data JSON request (@see {@link EtherlinkerRequestData})
     * @return Ajax response
     * @throws RestException error, which happens during request processing
     */
    @RequestMapping(value = "/getWalletBalance", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getWalletBalance(@RequestBody String data) throws RestException {
        try {
            return Ajax.successResponse(ethereumService.getBalance(getRequestData(data)));
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    /**
     * Transferring ether from user wallet to another wallet
     * @param data JSON request (@see {@link EtherlinkerRequestData})
     * @return Ajax response
     * @throws RestException error, which happens during request processing
     */
    @RequestMapping(value = "/transferEther", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> transferEther(@RequestBody String data) throws RestException {
        try {
            return Ajax.successResponse(ethereumService.transferEther(getRequestData(data)));
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    /**
     * Creating new wallet
     * @param data JSON request (@see {@link EtherlinkerRequestData})
     * @return Ajax response
     * @throws RestException error, which happens during request processing
     */
    @RequestMapping(value = "/createWallet", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> createWallet(@RequestBody String data) throws RestException {
        try {
            return Ajax.successResponse(ethereumService.createWallet(getRequestData(data)));
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    /**
     * Deploying new contract, which was already compiled by Web3j
     * @param data JSON request (@see {@link EtherlinkerRequestData})
     * @return Ajax response
     * @throws RestException error, which happens during request processing
     */
    @RequestMapping(value = "/deployContract", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> deployContract(@RequestBody String data) throws RestException {
        try {
            return Ajax.successResponse(ethereumService.deployContract(getRequestData(data)));
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    /**
     * Executing custom contract method
     * @param data JSON request (@see {@link EtherlinkerRequestData})
     * @return Ajax response
     * @throws RestException error, which happens during request processing
     */
    @RequestMapping(value = "/execContractMethod", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ExecContractMethod(@RequestBody String data) throws RestException {
        try {
            return Ajax.successResponse(ethereumService.execContractMethod(getRequestData(data)));
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    /**
     * Extracting {@link EtherlinkerRequestData} from JSON request
     * @param data JSON request (@see {@link EtherlinkerRequestData})
     * @return EtherlinkerRequestData
     * @throws RestException error, which happens during request processing
     */
    private EtherlinkerRequestData getRequestData(String data) throws RestException {
        try {

            // Check input params
            if (data == null || data.trim().equals("")) {
                throw new RestException("No valid request data");
            }
            if (data.trim().length() > 10000) {
                throw new RestException("No valid request data");
            }
            if (data.trim().length() < 1) {
                throw new RestException("No valid request data");
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(data, EtherlinkerRequestData.class);

        } catch (Exception e) {
            throw new RestException(e);
        }
    }

}
