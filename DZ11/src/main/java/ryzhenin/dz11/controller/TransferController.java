package ryzhenin.dz11.controller;

import org.springframework.web.bind.annotation.*;
import ryzhenin.dz11.dto.TransferRequest;
import ryzhenin.dz11.dto.TransferResponse;
import ryzhenin.dz11.service.TransferService;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }
    @PostMapping
    public TransferResponse transfer(@RequestBody TransferRequest request) {
        return transferService.transfer(request);
    }
}