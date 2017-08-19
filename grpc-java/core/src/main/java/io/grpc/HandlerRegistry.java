/*
 * Copyright 2014, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.grpc;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Registry of services and their methods used by servers to dispatching incoming calls.
 */
@ThreadSafe
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/933")
public abstract class HandlerRegistry {

  /**
   * Returns the {@link ServerServiceDefinition}s provided by the registry, or an empty list if not
   * supported by the implementation.
   */
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
  public List<ServerServiceDefinition> getServices() {
    return Collections.emptyList();
  }

  /**
   * Lookup a {@link ServerMethodDefinition} by its fully-qualified name.
   *
   * @param methodName to lookup {@link ServerMethodDefinition} for.
   * @param authority the authority for the desired method (to do virtual hosting). If {@code null}
   *        the first matching method will be returned.
   * @return the resolved method or {@code null} if no method for that name exists.
   */
  @Nullable
  public abstract ServerMethodDefinition<?, ?> lookupMethod(
      String methodName, @Nullable String authority);

  /**
   * Lookup a {@link ServerMethodDefinition} by its fully-qualified name.
   *
   * @param methodName to lookup {@link ServerMethodDefinition} for.
   * @return the resolved method or {@code null} if no method for that name exists.
   */
  @Nullable
  public final ServerMethodDefinition<?, ?> lookupMethod(String methodName) {
    return lookupMethod(methodName, null);
  }

}
