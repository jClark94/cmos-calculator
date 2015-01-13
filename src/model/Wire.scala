package model

abstract class Wire {
  def get() : Potential

  def clear() : Unit
}

class WireImpl extends Wire with Input with Output {
  override def get() : Potential = {
    var res : Potential = Undriven()
    for (source <- getSources) {
      if (source.get != Undriven()) {
        res = source.get
      }
    }
    res
  }

  override def clear : Unit = {
    clearSources
    clearDrains
  }
}
