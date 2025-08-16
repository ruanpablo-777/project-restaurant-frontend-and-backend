import express from 'express'
import path from 'path'
import { fileURLToPath } from 'url'
const app = express()

//porta do server
const PORT = process.env.PORT || 3001;

//ajustes para ES modules
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);


app.use(express.static(path.join(__dirname, 'public')));

app.listen(PORT, () => {
    console.log(`working in the port ${PORT}`)
})