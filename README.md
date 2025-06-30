# Cloud-Native Microservice
# Product Catalog 

## Overview
Containerized Spring Boot microservice with multiple API versions deployed on Kubernetes with CI/CD automation.

## Quick Start

### Prerequisites
- Docker
- Kubernetes/Minikube
- Java 11+
- Maven

### Local Setup
```bash
git clone <repo-url>
cd product-catalog
mvn spring-boot:run
```

### Docker Deployment
```bash
# Build image
docker build -t product-service:v2.0 .

# Run container
docker run -p 8080:8080 product-service:v2.0
```

### Kubernetes Deployment
```bash
# Start cluster
minikube start
minikube addons enable ingress

# Deploy
kubectl apply -f k8s/

# Access service
minikube tunnel
```

## API Documentation

**[📮 Postman Collection](https://kxld-4969301.postman.co/workspace/kxld's-Workspace~638a0202-4881-45c9-8a40-544f0617cade/collection/44593529-f16647ba-509c-40e2-b951-85bf4ecf9089?action=share&creator=44593529)**

### Endpoints
- `GET /api/v1/health` - Health check
- `GET /api/v1/products` - Get all products
- `POST /api/v1/products` - Create product
- `GET /api/v1/products/{id}` - Get product by ID
- `PUT /api/v1/products` - Update product
- `DELETE /api/v1/products/{id}` - Delete product
- `GET /api/v1/products/search?keyword=laptop` - Search products (v1.1+)

### Versions
- **v1.0**: Basic CRUD operations
- **v1.1**: + Search functionality
- **v2.0**: + Enhanced search with pagination

## Project Structure
```
├── src/
├── k8s/
│   ├── deployment-v1.yaml
│   ├── deployment-v2.yaml
│   └── ingress.yaml
├── .github/workflows/
├── Dockerfile
└── docker-compose.yml
```

## Testing
```bash
# Local testing
curl http://localhost:8080/api/v1/health

# Kubernetes testing
curl http://product-service.local/v1/health
```

## CI/CD
GitHub Actions pipeline automatically:
- Runs tests
- Builds Docker images
- Deploys to Kubernetes

Set required secrets:
- `DOCKERHUB_USERNAME`
- `DOCKERHUB_TOKEN`
