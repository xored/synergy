package com.xored.x5agent.ui.handlers

import org.eclipse.core.commands.{AbstractHandler, ExecutionEvent, ExecutionException}

class FailHandler extends AbstractHandler {
	
  override def execute(event:ExecutionEvent) =
    throw new RuntimeException("Yes, I've failed")

}
