package com.badboy.springcloud.controller;

import com.badboy.springcloud.entity.CommonResult;
import com.badboy.springcloud.entity.Payment;
import com.badboy.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("payment")
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("")
    public CommonResult create(@RequestParam("serial") String serial) {
        Payment payment = new Payment();
        payment.setSerial(serial);
        int index = paymentService.create(payment);
        if(index > 0) {
            return new CommonResult(200, "success", null);
        }
        return new CommonResult(400, "failed", null);
    }

    @GetMapping("")
    public CommonResult getPaymentById(@RequestParam("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(400, "failed", null);
        }
    }



}
