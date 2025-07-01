package com.chacha.create.controller.controller.mainhome.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("main/store")
public class StoreController {
    
	@GetMapping("/stores")
    public String showAllStoresPage() {
		return "main/mainStoreList";
    }
}
