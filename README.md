# Example of DDD usage with Spring framework.

## Problem
A driver can rent a car. One driver can rent only one car simultaneously. And one car can be rented by only one driver simultaneously.

A driver has a license. License is uniq among all drivers.
A car has a registration plate which is uniq as well.

## Solution description
Business logic organized as a [Domain Model](https://martinfowler.com/eaaCatalog/domainModel.html).
Application includes following layers:
- Domain model. It includes the essence of the business logic;
- Service layer. It includes application-specific business logic;
- Interface. It is responsible for interaction with IO (user input and storage).

So it implements principles of the [Clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).
Business logic is very complex, that's why domain is organized as a flat package. For complex domain usage of sub-packages usually makes sense.

Interface layer is the only layer that interacts with the framework. This approach is ideal according the Clean architecture.
But it requires some complexity (i.e. see `META-INF/orm.xml` and hierarchy of `tech.anokhin.carsharing.webapp.repositories.*Repository`)

Repositories are a part of the interface layer but it isn't obliged to be a part of the webapp.

## How to run
1. Download the code.
2. Use Maven to get dependencies
3. Run as normal Spring application.

[See](https://spring.io/guides/gs/serving-web-content/) 