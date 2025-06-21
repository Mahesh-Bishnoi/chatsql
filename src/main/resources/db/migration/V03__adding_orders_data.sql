-- Insert sample orders
INSERT INTO Orders (customer_id, order_date, total_amount, status) VALUES
(1, DATE '2025-06-01', 120.50, 'Processing'),
(1, DATE '2025-06-10', 89.99, 'Shipped'),
(2, DATE '2025-06-05', 230.00, 'Delivered'),
(3, DATE '2025-06-15', 49.95, 'Pending');