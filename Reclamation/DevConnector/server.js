const express=require('express');
const connectDB = require('./config/db');
const app = express();
//connectDB
connectDB();

// Init Middleware
app.use(express.json({ extended: false }));

//Define Routes
app.use('/api/reclamation', require('./routes/api/reclamation'));
app.get('/',(req,res)=>res.send('API Running'));
const PORT = process.env.PORT || 5000;
app.listen(PORT,() => console.log(`Server started on port ${PORT}`))

