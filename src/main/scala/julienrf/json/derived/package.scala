package julienrf.json

import play.api.libs.json.{OFormat, OWrites, Reads}
import shapeless.Lazy

package object derived {

  def reads[A](implicit derivedReads: Lazy[DerivedReads[A]]): Reads[A] = derivedReads.value

  def reads2[A](implicit derivedReads2: Lazy[DerivedReads2[A]]): Reads[A] = derivedReads2.value.reads

  def owrites[A](implicit derivedOWrites: Lazy[DerivedOWrites[A]]): OWrites[A] = derivedOWrites.value.owrites

  def oformat[A](implicit derivedReads: Lazy[DerivedReads[A]], derivedOWrites: Lazy[DerivedOWrites[A]]): OFormat[A] =
    OFormat(derivedReads.value, derivedOWrites.value.owrites)

}
