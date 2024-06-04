<?php

namespace App\Http\Controllers;

use App\Models\Participant;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Firebase\JWT\JWT;

class LoginController extends Controller
{
    public function login(Request $request)
    {
        $input = $request->all();
        $participant = Participant::where('email', $input['email'])->first();
        if ($participant == null) {
            return response()->json(['Message' => 'Correo no valido'], 400);
        }
        if ($request->password === $participant->password) {
            $key = env('JWT_SECRET');
            $algorithm = 'HS256';
            $time = time();
            $payload = array(
                'iat' => $time, // Tiempo que inició el token
                'exp' => $time + 60 * 60, // Tiempo que expirará el token (+1 hora)
                'data' => [ // información del usuario
                    'user' => $participant,
                ],
            );
            $jwt = JWT::encode($payload, $key, $algorithm);
            return response()->json([
                'authorization' => [
                    'token' => $jwt,
                    'type' => 'bearer',
                    'expires' => $time,
                ],
            ], 200);
        }else{
            return response()->json([
                'mensaje' => 'Contraseña invalida',
            ], 400);
        }
    }
}
