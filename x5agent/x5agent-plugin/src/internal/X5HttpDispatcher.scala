package com.xored.x5agent.core.internal

import scala.actors.Actor

// messages
object GotSomethingToSubmit

// component

trait X5HttpDispatcherComponent {

  def x5dispatcher:X5HttpDispatcher

  trait X5HttpDispatcher {
    def notifyGotSomethingToSubmit:Unit
  }

}

// implementation

trait X5HttpDispatcherComponentImpl extends X5HttpDispatcherComponent {
  this: 
    X5HttpDispatcherComponentImpl
    with X5HttpSubmitterComponent
    with X5AgentEssentials =>

  def x5dispatcher = X5HttpDispatcherImpl

  object X5HttpDispatcherImpl extends X5HttpDispatcher with Actor {
    start

    override def notifyGotSomethingToSubmit = this ! GotSomethingToSubmit

    var submitting = false
    var pending = false
    
    override def act = 
      loop {
        react {
          case GotSomethingToSubmit => 
            if (submitting) { pending = true }
            else { 
              submitting = true
              pending = false
              x5submitter ! Submit
            }

          case Submitted => {
            submitting = false
            if (pending) notifyGotSomethingToSubmit
          }

        }
      }
  }

}
