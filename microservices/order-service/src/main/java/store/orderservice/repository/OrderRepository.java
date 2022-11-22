package store.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
