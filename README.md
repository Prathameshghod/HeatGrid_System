# heatgrid_java

Full-stack HeatGrid: Spring Boot backend plus the original HeatGrid map frontend (search, MapLibre 3D buildings, layer toggles, control room, intervention sidebar).

## What is included
- Spring Boot backend with a mock city heat-analysis API
- React + Vite frontend copied from HeatGrid-main (MapLibre map, Nominatim search, simulation sliders)
- Vite proxies `/api` to the analysis service on port `8000` (same contract as the original FastAPI `POST /api/analyze-city` stream)

## Run it

### Backend (Spring Boot)
```bash
cd heatgrid_java/backend
mvn test
mvn spring-boot:run
```

### Analysis API (needed for the full map)
The map UI posts to `/api/analyze-city` and expects the original NDJSON stream. Run the HeatGrid-main FastAPI backend on port 8000.

### Frontend
```bash
cd heatgrid_java/frontend
npm install
npm run dev
```
