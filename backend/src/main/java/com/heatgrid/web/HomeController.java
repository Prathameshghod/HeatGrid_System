package com.heatgrid.web;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> home() {
        String html = """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>HeatGrid Java</title>
                    <style>
                      :root { color-scheme: dark; font-family: Inter, system-ui, sans-serif; }
                      body {
                        margin: 0;
                        min-height: 100vh;
                        display: grid;
                        place-items: center;
                        background: radial-gradient(circle at top, #1d3557, #08111d 58%);
                        color: #e5eefc;
                      }
                      main {
                        width: min(720px, calc(100vw - 32px));
                        padding: 32px;
                        border: 1px solid rgba(148, 163, 184, 0.18);
                        border-radius: 24px;
                        background: rgba(10, 18, 31, 0.82);
                        box-shadow: 0 24px 80px rgba(0, 0, 0, 0.35);
                      }
                      h1 { margin: 0 0 12px; font-size: clamp(2rem, 4vw, 3.2rem); }
                      p { line-height: 1.65; color: #b8c5d8; }
                      .links { display: flex; flex-wrap: wrap; gap: 12px; margin-top: 22px; }
                      a {
                        color: #07111e;
                        background: linear-gradient(135deg, #38bdf8, #34d399);
                        text-decoration: none;
                        font-weight: 700;
                        padding: 12px 16px;
                        border-radius: 14px;
                      }
                      code {
                        padding: 2px 8px;
                        border-radius: 999px;
                        background: rgba(255, 255, 255, 0.08);
                      }
                    </style>
                  </head>
                  <body>
                    <main>
                      <p>HeatGrid Java backend is running.</p>
                      <h1>Welcome to the HeatGrid Java API</h1>
                      <p>
                        Open the frontend dashboard at <code>http://localhost:5173</code> or
                        call <code>/api/analysis/{city}</code> for mock heat analysis data.
                      </p>
                      <div class="links">
                        <a href="http://localhost:5173">Open frontend dashboard</a>
                        <a href="/api/analysis/NIT%20Hamirpur">Try the API</a>
                      </div>
                    </main>
                  </body>
                </html>
                """;

        return ResponseEntity.ok(html);
    }
}