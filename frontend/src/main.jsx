import React from 'react'
import { createRoot } from 'react-dom/client'

function App() {
  return (
    <div>
      <h1>HeatGrid Frontend</h1>
      <p>Welcome — frontend skeleton.</p>
    </div>
  )
}

createRoot(document.getElementById('root')).render(<App />)
