# CQRS-POC
- The Command Query Responsibility Segregation (CQRS) pattern suggests that the system should maintain separate models for reading data (queries) and writing data (commands). By decoupling the read and write sides of the application, developers gain flexibility in scaling, optimizing, and evolving each side independently.


## When CQRS is Useful/ Advantages of CQRS:
- **High read load:** When applications have a significantly higher number of read operations compared to writes, by separating reads and writes, the read database can be optimized for fast retrieval, reducing latency and resource consumption.
-  **Complex queries:** When queries involve joining multiple tables or require complex aggregations, CQRS allows for optimized read databases by creating a denormalized datastore from multiple normalized database.
-   **Independent Scaling:** Command and query sides can scale independently based on workload demands. For instance, during peak usage periods, additional resources can be allocated to the command side to process a high volume of transaction requests efficiently. Similarly, read models can be horizontally scaled to accommodate increased read query loads without affecting the performance of the command side.
-   **Event-Driven Communication:** CQRS often employs event-driven architecture for asynchronous communication between the command and query sides. This simplifies consistency management and promotes eventual consistency. Apache Kafka Streams or RabbitMQ support event-driven communication and message queuing.
-   **Eventual Consistency:** CQRS typically involves accepting eventual consistency, meaning there might be a slight delay between updates on the command side and their reflection in the query side.
-    **Accurate Audit Trails:** Event Sourcing ensures that every state change in the system is captured as an immutable event. This allows for accurate audit trails, enabling developers to track the history of changes made to the application’s state over time. This is particularly valuable in industries with strict compliance requirements, such as finance or healthcare.
-    **Temporal Queries:** Since the entire history of state changes is preserved as a sequence of events, developers can perform temporal queries, such as “What was the state of the system at a specific point in time?” or “How did the state evolve over time?” This capability is valuable for debugging, analysis, and compliance purposes.

 ![image](https://github.com/Aabdelmajeed/CQRS-POC/assets/88937645/67583ab7-c9f9-44fb-80fb-9001ee7792c5)


#### ref:
- https://dip-mazumder.medium.com/optimize-microservices-with-high-read-load-cqrs-design-pattern-0c53793179e3#:~:text=Synchronizing%20databases%20in%20a%20CQRS,published%20via%20message%20broker%20systems.
- https://towardsdev.com/cqrs-in-action-building-robust-micro-services-with-spring-boot-68faa9133a4d
