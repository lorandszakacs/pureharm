/**
  * Copyright (c) 2019 BusyMachines
  *
  * See company homepage at: https://www.busymachines.com/
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package busymachines.pureharm

import shapeless.tag
import tag.@@

/**
  *
  * Example use case:
  * {{{
  * package object api {
  *   object SpecificString extends PhantomType[String]
  *   type SpecificString = SpecificString.Type
  * }
  * }}}
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 02 Apr 2019
  *
  */
trait PhantomType[T] {
  type Tag <: this.type
  final type Type = T @@ Tag

  @inline def apply(value: T): T @@ Tag =
    tag[Tag](value)

  /**
    * alias for [[apply]]
    */
  @inline def spook(value: T): T @@ Tag =
    apply(value)

  @inline final def despook(spook: T @@ Tag): T = spook
}