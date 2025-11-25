CREATE TABLE events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    venue_id VARCHAR(255) -- Logical reference to MongoDB Venue ID
);
