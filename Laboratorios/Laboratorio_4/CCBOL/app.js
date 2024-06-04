const express = require("express");
const myConnection = require("express-myconnection");
const morgan = require("morgan");
const mysql = require("mysql");
const path = require("path");
const app = express();
const PORT = 10000;

app.set("port", process.env.PORT || 2000);
app.use(express.urlencoded({ extended: false }));
app.use(express.json());    

app.use(express.static(path.join(__dirname, "public")));

app.use(morgan("dev"));
app.use(
  myConnection(
    mysql,
    {
      host: "localhost",
      user: "root",
      password: "",
      port: 3306,
      database: "bd_ccbol",
    },
    "single"
  )
);

app.set("view engine", "ejs");
// Ruta para obtener las categorías
app.use("/login", require("./routes/login"));

// Iniciar servidor
app.listen(PORT, () => {
    console.log(`Servidor corriendo en el puerto http://localhost:${PORT}/login`);
  });