var amqp = require('amqplib/callback_api');
const nodemailer = require('nodemailer');

const controller = {};

controller.view = (req, res) => {
    res.render('login');

    // Renderizar una respuesta al usuario
    amqp.connect('amqp://enc:Hola123hola1@localhost', function (error0, connection) {
        if (error0) throw error0;

        connection.createChannel(function (error1, channel) {
            if (error1) throw error1;

            var queue = 'form_data_queue';
            channel.assertQueue(queue, { durable: true });
            channel.prefetch(1);
            console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", queue);

            channel.consume(queue, function (msg) {
                let formData = JSON.parse(msg.content.toString());
                console.log(" [x] Received '%s'", formData.correoElectronico); // Suponiendo que formData contiene un campo 'email'

                // Configuración del correo electrónico
                let mailOptions = {
                    from: 'universidad.usfx.405@gmail.com',
                    to: formData.correoElectronico, // El destinatario se extrae del mensaje
                    subject: 'Registro Exitoso',
                    text: '¡Hola! Tu registro ha sido exitoso. Bienvenido a la comunidad.',
                    html: '<b>¡Hola!</b><p>Tu registro ha sido exitoso. Bienvenido a la comunidad.</p>'
                };

                // Enviar el correo electrónico
                envio.sendMail(mailOptions, function (error, info) {
                    if (error) {
                        console.log('Error sending mail: ' + error);
                    } else {
                        console.log('Email sent: ' + info.response);
                    }
                });

                // Acusar recibo del mensaje
                channel.ack(msg);
            }, {
                noAck: false
            });
        });
    });
};

controller.send = async (req, res) => {
    const { ci, nombres, apellidos, fechaNacimiento, carrera, ciudad, direccion, correoElectronico } = req.body;

    // Crear un objeto con los datos del formulario
    const formData = {
        correoElectronico
    };

    // Conectar a RabbitMQ y enviar los datos a la cola
    amqp.connect('amqp://enc:Hola123hola1@localhost', function (error0, connection) {
        if (error0) {
            throw error0;
        }
        connection.createChannel(function (error1, channel) {
            if (error1) {
                throw error1;
            }
            var queue = 'form_data_queue';

            channel.assertQueue(queue, {
                durable: true
            });

            // Convertir los datos del formulario a JSON y enviarlos a la cola
            const msg = JSON.stringify(formData);

            channel.sendToQueue(queue, Buffer.from(msg), {
                persistent: true
            });
            console.log(" [x] Sent '%s'", msg);

            // Cerrar la conexión después de enviar los datos
            setTimeout(function () {
                connection.close();
            }, 500);
        });
    });


    req.getConnection((err, conn) => {
        if (err) throw err; // Asegúrate de manejar errores de conexión adecuadamente

        // Insertar los datos en la base de datos
        conn.query('INSERT INTO user (ci, nombre, apellidos, nacimiento, carrera, ciudad, direccion, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)', [ci, nombres, apellidos, fechaNacimiento, carrera, ciudad, direccion, correoElectronico], (error, results) => {
            if (error) throw error; // Manejo de errores de la consulta

            res.render('login', {
                alert: true,
                alertTitle: 'Registro Exitoso',
                alertMessage: 'Datos guardados correctamente',
                alertIcon: 'success',
                showConfirmButton: false,
                timer: 1500,
                ruta: 'login' // Cambia esto a la ruta que prefieras después del registro
            });
        });
    });

};



// Configuración del transportador de correo
let envio = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: 'universidad.usfx.405@gmail.com', // Tu dirección de correo electrónico
        pass: 'ariz rwsi pmis shhw' // Tu contraseña de correo electrónico
    }
});

module.exports = controller;