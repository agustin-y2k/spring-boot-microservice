package store.inventoryservice.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import store.inventoryservice.dto.InventoryResponse;
import store.inventoryservice.model.Inventory;
import store.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Wait started");
        Thread.sleep(10000);
        log.info("Wait Ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(this::mapInventoryAndThrowErrorIfBadluck)
                .toList();
    }

    private InventoryResponse mapInventoryAndThrowErrorIfBadluck(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
