const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('bd_oficina_tramites', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Qualifications = sequelize.define('qualifications', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    ci: {
        type: DataTypes.STRING,
        allowNull: false
    },
    apellidos: {
        type: DataTypes.STRING,
        allowNull: false
    },
    nombres: {
        type: DataTypes.STRING,
        allowNull: false
    },
    Bachiller: {
        type: DataTypes.BOOLEAN,
        allowNull: false
    }
}, {
    tableName: 'qualifications',
    timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Qualifications };

