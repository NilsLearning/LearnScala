/*
 * Copyright (C) 2019-2021 Lightbend Inc. <https://www.lightbend.com>
 */

package test.actor.dispatcher.other

import akka.annotation.InternalApi

import scala.annotation.Annotation

/**
 * INTERNAL API
 *
 * Annotation to mark files that need ccompat to be imported for Scala 2.11 and/or 2.12,
 * but not 2.13. Gets rid of the 'unused import' warning on 2.13.
 */
@InternalApi
private[test] class ccompatUsedUntil213 extends Annotation
