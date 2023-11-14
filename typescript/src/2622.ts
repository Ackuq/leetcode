class TimeLimitedCache {
  private cache: Map<number, number> = new Map();
  private timers: Map<number, number> = new Map();

  set(key: number, value: number, duration: number): boolean {
    const hit = this.cache.get(key) !== undefined;
    const previousTimer = this.timers.get(key);
    if (previousTimer) {
      clearTimeout(previousTimer);
    }

    this.cache.set(key, value);

    const timer = setTimeout(() => {
      this.cache.delete(key);
      this.timers.delete(key);
    }, duration);

    this.timers.set(key, timer as unknown as number);

    return hit;
  }

  get(key: number): number {
    return this.cache.get(key) ?? -1;
  }

  count(): number {
    return this.cache.size;
  }
}

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */

/**
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */

export { TimeLimitedCache };
