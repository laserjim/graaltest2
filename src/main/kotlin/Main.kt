package org.example

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.Value
import java.io.File


fun main() {
    Context.newBuilder().allowAllAccess(true)
        .allowAllAccess(true)
    	.option("python.PythonPath", "/root/graaltest2/aider:/root/.venv/lib/python3.11/site-packages")
        //.option("python.ForceImportSite", "true")
        .option("python.Executable", "/root/graaltest2/aider/.venv/bin/graalpy")
        .build().use { context ->
        context.eval("python", "print('Hello Python!')")

        try {
            context.eval(Source.newBuilder("python", File("./aider/hello.py")).build())

            val hearAnalysisFn: Value = context.getBindings("python").getMember("helloworld")

            val heartAnalysisReport: Value = hearAnalysisFn.execute()
            System.out.println("the result is :" + heartAnalysisReport.toString())
        } catch (e: Exception) {
            println("Exception : ")
            e.printStackTrace()
        }
    }
}

