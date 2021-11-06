package com.axiom.search.api.control.clients;

import com.axiom.search.api.boundary.helper.dto.MobileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "RunMocky", url = "${mobile.data.url}")
public interface SearchClient {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<MobileDto> searchMobiles();
}