<?php

namespace App\Http\Controllers;

use App\Models\Academic;
use Illuminate\Http\Request;

class AcademicController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $academic = Academic::all();
        return response()->json($academic, 200);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $academic = Academic::create($request->all());
        return response()->json($academic, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $ci)
    {
        $academic = Academic::where('ci', $ci)->first();
        if (!$academic) {
            return response()->json([
                'message' => 'persona no encontrada'
            ], 404);
        } else {
            return response()->json($academic, 200);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $academic = Academic::find($id);
        if (!$academic) {
            return response()->json([
                'message' => 'Registro no encontrado'
            ], 404);
        }

        $academic->update(request()->all());

        // Diferenciar entre PUT y PATCH
        // if ($request->isMethod('patch')) {
        //     $input = $request->only([
        //         'ci',
        //         'nombre_completo',
        //         'titulo',
        //         'fecha_emision',
        //     ]);
        // } else {
        //     $input = $request->all();
        // }

        //$academic->fill($input);
        //$academic->save();

        return response()->json([
            'message' => 'Registro actualizado correctamente',
            'academic' => $academic
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $academic = Academic::find($id);
        $academic->delete();

        return response()->json([
            'message' => 'Registro eliminado correctamente',
            'department' => $academic
        ], 201);
    }
}
