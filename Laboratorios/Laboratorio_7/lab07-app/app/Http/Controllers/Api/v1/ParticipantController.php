<?php

namespace App\Http\Controllers\Api\v1;

use App\Http\Controllers\Controller;
use App\Models\Participant;
use Illuminate\Http\Request;

class ParticipantController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $participant = Participant::all();
        return response()->json($participant, 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'nombre' => 'required',
            'apellidos' => 'required',
            'email' => 'required',
            'password' => 'required',
            'rol' => 'required',
        ]);
        $participant = Participant::create($request->all());
        return response()->json($participant, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $participant = Participant::find($id);
        if(!$participant) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }else{
            return response()->json($participant, 200);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $participant = Participant::find($id);
        if (!$participant) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }
    
        // Diferenciar entre PUT y PATCH
        if ($request->isMethod('patch')) {
            $input = $request->only([
                'nombre',
                'apellidos',
                'email',
                'password',
                'rol']);
        } else {
            $input = $request->all();
        }
    
        $participant->fill($input);
        $participant->save();
    
        return response()->json([
            'message' => 'Registro actualizado correctamente',
            'department' => $participant
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $participant = Participant::find($id);
        $participant->delete();

        return response()->json([
            'message' => 'Registro eliminado correctamente',
            'department' => $participant
        ], 201);
    }
}
